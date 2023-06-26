package com.example.booksapp.data.repository.dataSource

import com.example.booksapp.data.model.Item
import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {
    suspend fun saveBookToDB(book: Item)
    fun getSavedBooks(): Flow<List<Item>>
    suspend fun deleteBookFromDB(article: Item)


}