package com.northside_shawty.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.northside_shawty.data.database.MessageDao
import com.northside_shawty.data.mappers.MessageMapper
import com.northside_shawty.data.models.Message

class MessageRepositoryImpl (
    private val messageDao: MessageDao,
    private val messageMapper: MessageMapper
) : MessageRepository {

    override suspend fun insertMessage(message: Message) {
        val messageEntity = messageMapper.mapToDataEntity(message)
        messageDao.insertMessage(messageEntity)
    }

    override fun getMessages(): LiveData<List<Message>> {
        return Transformations.map(messageDao.getAllMessages()) { entities ->
            messageMapper.mapToDomainEntities(entities)
        }
    }
}