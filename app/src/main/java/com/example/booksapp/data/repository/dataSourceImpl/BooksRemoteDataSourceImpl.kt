package com.example.booksapp.data.repository.dataSourceImpl

import com.example.booksapp.data.api.BooksAPIService
import com.example.booksapp.data.model.APIResponse
import com.example.booksapp.data.repository.dataSource.BooksRemoteDataSource
import retrofit2.Response

class BooksRemoteDataSourceImpl(
    private val booksAPIService: BooksAPIService
) : BooksRemoteDataSource {

    override suspend fun getBooks(isbn: String): Response<APIResponse> {
        return booksAPIService.getBooks(isbn)
    }
}