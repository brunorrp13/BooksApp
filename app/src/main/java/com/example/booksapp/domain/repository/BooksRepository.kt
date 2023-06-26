package com.example.booksapp.domain.repository

import com.example.booksapp.data.model.APIResponse
import com.example.booksapp.data.model.Item
import com.example.booksapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    suspend fun getBooks(isbn: String): Resource<APIResponse>
    suspend fun saveBooks(book: Item)
    suspend fun deleteBook(book: Item)
    fun getSavedBooks(): Flow<List<Item>>
}
