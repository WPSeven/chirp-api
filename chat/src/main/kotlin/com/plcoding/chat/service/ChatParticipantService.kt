package com.plcoding.chat.service

import com.plcoding.chat.domain.models.ChatParticipant
import com.plcoding.chat.infra.database.mappers.toChatParticipant
import com.plcoding.chat.infra.database.mappers.toChatParticipantEntity
import com.plcoding.chat.infra.database.repositories.ChatParticipantRepository
import com.plcoding.chirp.domain.type.UserId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ChatParticipantService(
    private val chatParticipantRepository: ChatParticipantRepository,
) {

    fun createChatParticipant(
        chatParticipant: ChatParticipant
    ) {
        chatParticipantRepository.save(
            chatParticipant.toChatParticipantEntity()
        )
    }

    fun findChatParticipantById(userId: UserId): ChatParticipant? {
        return chatParticipantRepository.findByIdOrNull(userId)?.toChatParticipant()
    }

    fun findChatParticipantByEmailOrUsername(
        query: String
    ): ChatParticipant? {
        val normalizedQuery = query.lowercase().trim()
        return chatParticipantRepository.findByEmailOrUsername(
            query = normalizedQuery
        )?.toChatParticipant()
    }
}