package com.plcoding.chat.api.controllers

import com.plcoding.chat.api.dto.ChatParticipantDto
import com.plcoding.chat.api.mappers.toChatParticipantDto
import com.plcoding.chat.service.ChatParticipantService
import com.plcoding.chirp.api.util.requestUserId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/chat/participants")
class ChatParticipantController(
    private val chatParticipantService: ChatParticipantService
) {

    @GetMapping
    fun getChatParticipantByUsernameOrEmail(
        @RequestParam(required = false) query: String?
    ): ChatParticipantDto {
        val participant = if(query == null) {
            chatParticipantService.findChatParticipantById(requestUserId)
        } else {
            chatParticipantService.findChatParticipantByEmailOrUsername(query)
        }

        return participant?.toChatParticipantDto()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}