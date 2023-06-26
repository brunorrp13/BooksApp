package com.example.booksapp.domain.usecase

import com.example.booksapp.data.model.Item
import com.example.booksapp.domain.repository.BooksRepository

class DeleteSavedBooksUseCase(private val booksRepository: BooksRepository) {
    suspend fun execute(book: Item) = booksRepository.deleteBook(book)
}