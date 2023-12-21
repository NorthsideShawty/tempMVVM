package com.northside_shawty.messanger2.di

import android.content.Context
import androidx.room.Room
import com.northside_shawty.data.database.MessageDao
import com.northside_shawty.data.database.MessageDatabase
import com.northside_shawty.data.mappers.MessageMapper
import com.northside_shawty.data.mappers.MessageMapperImpl
import com.northside_shawty.data.repository.MessageRepository
import com.northside_shawty.data.repository.MessageRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideMessageRepository(
        messageDao: MessageDao,
        messageMapper: MessageMapper
    ) : MessageRepository {
        return MessageRepositoryImpl(messageDao, messageMapper)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MessageDatabase {
        return Room.databaseBuilder(
            context,
            MessageDatabase::class.java,
            "messenger_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMessageDao(database: MessageDatabase): MessageDao {
        return database.messageDao()
    }

    @Provides
    fun provideMessageMapper() : MessageMapper {
        return MessageMapperImpl()
    }
}