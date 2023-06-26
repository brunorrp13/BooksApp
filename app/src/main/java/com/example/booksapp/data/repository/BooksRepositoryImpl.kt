package com.example.booksapp.data.repository

import com.example.booksapp.data.repository.dataSource.BooksRemoteDataSource
import com.example.booksapp.data.util.Resource
import com.example.booksapp.data.model.APIResponse
import com.example.booksapp.data.model.Item
import com.example.booksapp.data.repository.dataSource.BooksLocalDataSource
import com.example.booksapp.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource,
    private val booksLocalDataSource: BooksLocalDataSource
) : BooksRepository {

    override suspend fun getBooks(isbn: String): Resource<APIResponse> {
        return responseToResource(booksRemoteDataSource.getBooks(isbn))
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun saveBooks(book: Item) {
        booksLocalDataSource.saveBookToDB(book)
    }

    override suspend fun deleteBook(book: Item) {
        booksLocalDataSource.deleteBookFromDB(book)
    }

    override fun getBooks(): Flow<List<Item>> {
        return booksLocalDataSource.getSavedBooks()
    }
}