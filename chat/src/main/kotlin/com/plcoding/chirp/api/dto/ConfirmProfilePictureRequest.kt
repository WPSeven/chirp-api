package com.plcoding.chirp.api.dto

import jakarta.validation.constraints.NotBlank

data class ConfirmProfilePictureRequest(
    @field:NotBlank
    val publicUrl: String
)
