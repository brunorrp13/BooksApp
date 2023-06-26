package com.example.booksapp.domain.usecase

import com.example.booksapp.data.model.APIResponse
import com.example.booksapp.data.util.Resource
import com.example.booksapp.domain.repository.BooksRepository

class GetBooksUseCase(private val booksRepository: BooksRepository) {

    suspend fun execute(isbn: String): Resource<APIResponse> {
        return booksRepository.getBooks(isbn)
    }
}