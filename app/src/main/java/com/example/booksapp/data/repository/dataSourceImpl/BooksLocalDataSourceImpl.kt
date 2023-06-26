package com.example.booksapp.data.repository.dataSourceImpl

import com.example.booksapp.data.db.BooksDAO
import com.example.booksapp.data.model.Item
import com.example.booksapp.data.repository.dataSource.BooksLocalDataSource
import kotlinx.coroutines.flow.Flow

class BooksLocalDataSourceImpl(
    private val booksDAO: BooksDAO
) : BooksLocalDataSource {

    override suspend fun saveBookToDB(book: Item) {
        booksDAO.insert(book)
    }

    override fun getSavedBooks(): Flow<List<Item>> {
        return booksDAO.getAllBooks()
    }

    override suspend fun deleteBookFromDB(book: Item) {
        booksDAO.deleteBook(book)
    }
}