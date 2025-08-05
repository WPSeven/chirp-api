package com.plcoding.chirp.api.mappers

import com.plcoding.chirp.api.dto.ApiKeyDto
import com.plcoding.chirp.domain.model.ApiKey

fun ApiKey.toApiKeyDto(): ApiKeyDto {
    return ApiKeyDto(
        key = key,
        validFrom = validFrom,
        expiresAt = expiresAt,
    )
}