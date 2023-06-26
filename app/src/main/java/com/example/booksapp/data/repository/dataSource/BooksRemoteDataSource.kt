package com.example.booksapp.data.repository.dataSource

import com.example.booksapp.data.model.APIResponse
import retrofit2.Response

interface BooksRemoteDataSource {
    suspend fun getBooks(isbn: String): Response<APIResponse>
}
