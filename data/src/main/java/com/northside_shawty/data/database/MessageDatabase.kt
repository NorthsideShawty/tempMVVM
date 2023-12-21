package com.northside_shawty.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MessageEntity::class], version = 1, exportSchema = false)
abstract class MessageDatabase  : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}