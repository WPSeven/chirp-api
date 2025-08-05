package com.plcoding.chirp.infra.database.mappers

import com.plcoding.chirp.domain.model.ApiKey
import com.plcoding.chirp.infra.database.entities.ApiKeyEntity

fun ApiKeyEntity.toApiKey(): ApiKey {
    return ApiKey(
        key = key,
        validFrom = validFrom,
        expiresAt = expiresAt,
    )
}