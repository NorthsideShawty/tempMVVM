package com.northside_shawty.messanger2.di

import com.northside_shawty.data.repository.MessageRepository
import com.northside_shawty.domain.usecases.GetMessageUseCase
import com.northside_shawty.domain.usecases.SendMessageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideSendMessageUseCase(messageRepository: MessageRepository): SendMessageUseCase {
        return SendMessageUseCase(messageRepository)
    }

    @Provides
    fun provideGetMessageUseCase(messageRepository: MessageRepository): GetMessageUseCase {
        return GetMessageUseCase(messageRepository)
    }

}