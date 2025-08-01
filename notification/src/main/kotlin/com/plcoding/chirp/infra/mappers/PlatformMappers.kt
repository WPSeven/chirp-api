package com.plcoding.chirp.infra.mappers

import com.plcoding.chirp.domain.model.DeviceToken
import com.plcoding.chirp.infra.database.DeviceTokenEntity
import com.plcoding.chirp.infra.database.PlatformEntity

fun DeviceToken.Platform.toPlatformEntity(): PlatformEntity {
    return when(this) {
        DeviceToken.Platform.ANDROID -> PlatformEntity.ANDROID
        DeviceToken.Platform.IOS -> PlatformEntity.IOS
    }
}

fun PlatformEntity.toPlatform(): DeviceToken.Platform {
    return when(this) {
        PlatformEntity.ANDROID -> DeviceToken.Platform.ANDROID
        PlatformEntity.IOS -> DeviceToken.Platform.IOS
    }
}