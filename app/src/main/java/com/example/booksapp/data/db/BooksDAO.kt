package com.example.booksapp.data.db

import androidx.room.*
import com.example.booksapp.data.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface BooksDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Item)

    @Query("SELECT * FROM books")
    fun getAllBooks(): Flow<List<Item>>

    @Delete
    suspend fun deleteBook(book: Item)



}