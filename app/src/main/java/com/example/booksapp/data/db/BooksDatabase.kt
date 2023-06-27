package com.example.booksapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.booksapp.data.model.Item

@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class BooksDatabase : RoomDatabase(){
    abstract fun getBooksDAO():BooksDAO
}
