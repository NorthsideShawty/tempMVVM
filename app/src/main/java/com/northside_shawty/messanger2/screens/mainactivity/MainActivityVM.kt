package com.northside_shawty.messanger2.screens.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.northside_shawty.data.models.Message
import com.northside_shawty.domain.usecases.GetMessageUseCase
import com.northside_shawty.domain.usecases.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainActivityVM @Inject constructor (
    private val sendMessageUseCase: SendMessageUseCase,
    private val getMessageUseCase: GetMessageUseCase
) : ViewModel() {

    fun sendMessage(text: String, timestamp: Long) {
        val message = Message(id = 0, senderName = "User", text = text, timestamp = timestamp)
        viewModelScope.launch {
            sendMessageUseCase.sendMessage(message)
        }
    }

    fun loadMessages(): LiveData<List<Message>> {
        return getMessageUseCase.getMessages()
    }
}