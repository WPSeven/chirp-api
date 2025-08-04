package com.plcoding.chirp.domain.event

import com.plcoding.chirp.domain.type.ChatId
import com.plcoding.chirp.domain.type.UserId

data class ChatParticipantsJoinedEvent(
    val chatId: ChatId,
    val userIds: Set<UserId>
)
