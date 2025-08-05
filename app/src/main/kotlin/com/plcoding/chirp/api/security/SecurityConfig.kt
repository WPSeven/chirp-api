package com.plcoding.chirp.api.security

import com.plcoding.chirp.api.config.ApiKeyAuthFilter
import com.plcoding.chirp.api.config.JwtAuthFilter
import jakarta.servlet.DispatcherType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.HttpStatusEntryPoint
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig {

    @Bean
    fun filterChain(httpSecurity: HttpSecurity, jwtAuthFilter: JwtAuthFilter,
                    apiKeyAuthFilter: ApiKeyAuthFilter
    ): SecurityFilterChain {
        return httpSecurity
            .csrf { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/api/auth/**")
                    .permitAll()
                    .requestMatchers("/api/auth/change-password")
                    .authenticated()
                    .dispatcherTypeMatchers(
                        DispatcherType.ERROR,
                        DispatcherType.FORWARD
                    )
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .addFilterBefore(apiKeyAuthFilter, UsernamePasswordAuthenticationFilter::class.java)
            .addFilterAfter(jwtAuthFilter, ApiKeyAuthFilter::class.java)
            .exceptionHandling { configurer ->
                configurer
                    .authenticationEntryPoint(HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            }
            .build()
    }
}