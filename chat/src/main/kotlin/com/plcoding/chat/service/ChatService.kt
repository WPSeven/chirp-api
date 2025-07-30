package com.plcoding.chat.service

import com.plcoding.chat.domain.exception.ChatParticipantNotFoundException
import com.plcoding.chat.domain.exception.InvalidChatSizeException
import com.plcoding.chat.domain.models.Chat
import com.plcoding.chat.infra.database.entities.ChatEntity
import com.plcoding.chat.infra.database.mappers.toChat
import com.plcoding.chat.infra.database.repositories.ChatParticipantRepository
import com.plcoding.chat.infra.database.repositories.ChatRepository
import com.plcoding.chirp.domain.type.UserId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ChatService(
    private val chatRepository: ChatRepository,
    private val chatParticipantRepository: ChatParticipantRepository,
) {

    @Transactional
    fun createChat(
        creatorId: UserId,
        otherUserIds: Set<UserId>
    ): Chat {
        val otherParticipants = chatParticipantRepository.findByUserIdIn(
            userIds = otherUserIds
        )

        val allParticipants = (otherParticipants + creatorId)
        if(allParticipants.size < 2) {
            throw InvalidChatSizeException()
        }

        val creator = chatParticipantRepository.findByIdOrNull(creatorId)
            ?: throw ChatParticipantNotFoundException(creatorId)

        return chatRepository.save(
            ChatEntity(
                creator = creator,
                participants = setOf(creator) + otherParticipants
            )
        ).toChat(lastMessage = null)
    }
}