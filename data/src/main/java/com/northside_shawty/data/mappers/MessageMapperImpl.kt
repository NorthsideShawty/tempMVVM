package com.northside_shawty.data.mappers

import com.northside_shawty.data.database.MessageEntity
import com.northside_shawty.data.models.Message

class MessageMapperImpl : MessageMapper {

    override fun mapToDomainEntity(entity: MessageEntity): Message {
        return Message(
            id = entity.id,
            text = entity.text,
            senderName = entity.senderName,
            timestamp = entity.timestamp
        )
    }

    override fun mapToDomainEntities(entities: List<MessageEntity>): List<Message> {
        return entities.map { mapToDomainEntity(it) }
    }

    override fun mapToDataEntity(message: Message): MessageEntity {
        return MessageEntity(
            id = message.id,
            text = message.text,
            senderName = message.senderName,
            timestamp = message.timestamp
        )
    }

    override fun mapToDataEntities(messages: List<Message>): List<MessageEntity> {
        return messages.map { mapToDataEntity(it) }
    }
}