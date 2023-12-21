package com.northside_shawty.data.repository

import androidx.lifecycle.LiveData
import com.northside_shawty.data.database.MessageEntity
import com.northside_shawty.data.models.Message
import kotlinx.coroutines.flow.Flow

interface MessageRepository {
    suspend fun insertMessage(message: Message)
    fun getMessages(): LiveData<List<Message>>
}