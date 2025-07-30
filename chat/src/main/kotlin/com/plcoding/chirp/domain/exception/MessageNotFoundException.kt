package com.plcoding.chirp.domain.exception

import com.plcoding.chirp.domain.type.ChatMessageId

class MessageNotFoundException(
    private val id: ChatMessageId
): RuntimeException(
    "Message with ID $id not found"
)