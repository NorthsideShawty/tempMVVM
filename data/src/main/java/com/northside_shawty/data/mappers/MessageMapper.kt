package com.northside_shawty.data.mappers

import com.northside_shawty.data.database.MessageEntity
import com.northside_shawty.data.models.Message

interface MessageMapper {
    fun mapToDomainEntity(entity: MessageEntity): Message
    fun mapToDataEntity(model: Message): MessageEntity
    fun mapToDomainEntities(entities: List<MessageEntity>): List<Message>
    fun mapToDataEntities(messages: List<Message>): List<MessageEntity>
}