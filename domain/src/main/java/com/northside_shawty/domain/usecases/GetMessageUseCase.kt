package com.northside_shawty.domain.usecases

import androidx.lifecycle.LiveData
import com.northside_shawty.data.models.Message
import com.northside_shawty.data.repository.MessageRepository
import kotlinx.coroutines.flow.Flow

class GetMessageUseCase(private val messageRepository: MessageRepository) {

    fun getMessages(): LiveData<List<Message>> {
        return messageRepository.getMessages()
    }
}