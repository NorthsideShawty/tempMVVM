package com.northside_shawty.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("text") val text: String,
    @ColumnInfo("senderName") val senderName: String,
    @ColumnInfo("timestamp") val timestamp: Long
)
