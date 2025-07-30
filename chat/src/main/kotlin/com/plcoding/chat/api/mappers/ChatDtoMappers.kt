package com.plcoding.chat.api.mappers

import com.plcoding.chat.api.dto.ChatDto
import com.plcoding.chat.api.dto.ChatMessageDto
import com.plcoding.chat.api.dto.ChatParticipantDto
import com.plcoding.chat.domain.models.Chat
import com.plcoding.chat.domain.models.ChatMessage
import com.plcoding.chat.domain.models.ChatParticipant

fun Chat.toChatDto(): ChatDto {
    return ChatDto(
        id = id,
        participants = participants.map {
            it.toChatParticipantDto()
        },
        lastActivityAt = lastActivityAt,
        lastMessage = lastMessage?.toChatMessageDto(),
        creator = creator.toChatParticipantDto()
    )
}

fun ChatMessage.toChatMessageDto(): ChatMessageDto {
    return ChatMessageDto(
        id = id,
        chatId = chatId,
        content = content,
        createdAt = createdAt,
        senderId = sender.userId
    )
}

fun ChatParticipant.toChatParticipantDto(): ChatParticipantDto {
    return ChatParticipantDto(
        userId = userId,
        username = username,
        email = email,
        profilePictureUrl = profilePictureUrl
    )
}