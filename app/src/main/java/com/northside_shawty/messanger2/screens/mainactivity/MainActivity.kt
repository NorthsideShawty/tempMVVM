package com.northside_shawty.messanger2.screens.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.EditText
import androidx.activity.viewModels
import com.northside_shawty.messanger2.databinding.ActivityMainBinding
import com.northside_shawty.messanger2.screens.mainactivity.adapters.MessageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm : MainActivityVM by viewModels()
    private lateinit var messageAdapter : MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        messageAdapter = MessageAdapter()
        binding.messRV.adapter = messageAdapter

        vm.loadMessages().observe(this) { messages ->
            messageAdapter.setMessages(messages)
        }

        binding.buttonSend.setOnClickListener {
            val messET: EditText = binding.editTextMessage
            val text = messET.text.toString()
            if (text.isNotEmpty()) {
                vm.sendMessage(text, System.currentTimeMillis())
                messET.text.clear()
            }
        }
    }
}