package com.plcoding.chirp.api.dto.ws

import com.plcoding.chirp.domain.type.UserId

data class ProfilePictureUpdateDto(
    val userId: UserId,
    val newUrl: String?
)
