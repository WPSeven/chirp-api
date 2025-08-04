package com.plcoding.chirp.api.dto

import jakarta.validation.constraints.Email

data class EmailRequest(
    @field:Email
    val email: String
)
