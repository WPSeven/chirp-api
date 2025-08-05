package com.plcoding.chirp.api.dto

import java.time.Instant

data class ApiKeyDto(
    val key: String,
    val validFrom: Instant,
    val expiresAt: Instant,
)
