package com.northside_shawty.domain.usecases

import com.northside_shawty.data.models.Message
import com.northside_shawty.data.repository.MessageRepository

class SendMessageUseCase(private val messageRepository: MessageRepository) {

    suspend fun sendMessage(message: Message) {
        messageRepository.insertMessage(message)
    }
}