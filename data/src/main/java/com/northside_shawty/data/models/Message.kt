package com.northside_shawty.data.models

data class Message(
    val id: Int,
    val text: String,
    val senderName: String,
    val timestamp: Long
)