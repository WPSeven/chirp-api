package com.plcoding.chirp.api.mappers

import com.plcoding.chirp.api.dto.DeviceTokenDto
import com.plcoding.chirp.api.dto.PlatformDto
import com.plcoding.chirp.domain.model.DeviceToken

fun DeviceToken.toDeviceTokenDto(): DeviceTokenDto {
    return DeviceTokenDto(
        userId = userId,
        token = token,
        createdAt = createdAt
    )
}

fun PlatformDto.toPlatformDto(): DeviceToken.Platform {
    return when(this) {
        PlatformDto.ANDROID -> DeviceToken.Platform.ANDROID
        PlatformDto.IOS -> DeviceToken.Platform.IOS
    }
}