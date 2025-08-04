package com.plcoding.chirp

import com.plcoding.chirp.infra.database.entities.UserEntity
import com.plcoding.chirp.infra.database.repositories.UserRepository
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Component

@SpringBootApplication
@EnableScheduling
class ChirpApplication

fun main(args: Array<String>) {
	runApplication<ChirpApplication>(*args)
}