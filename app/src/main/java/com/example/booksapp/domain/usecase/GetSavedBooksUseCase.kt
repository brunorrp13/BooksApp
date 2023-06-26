package com.example.booksapp.domain.usecase

import com.example.booksapp.data.model.Item
import com.example.booksapp.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow

class GetSavedBooksUseCase(private val booksRepository: BooksRepository) {
    fun execute(): Flow<List<Item>>{
        return booksRepository.getSavedBooks()
    }
}