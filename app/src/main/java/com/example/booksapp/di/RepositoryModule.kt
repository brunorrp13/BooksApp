package com.example.booksapp.di

import com.example.booksapp.data.repository.BooksRepositoryImpl
import com.example.booksapp.data.repository.dataSource.BooksLocalDataSource
import com.example.booksapp.data.repository.dataSource.BooksRemoteDataSource
import com.example.booksapp.domain.repository.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideBooksRepository(
        booksRemoteDataSource: BooksRemoteDataSource,
        booksLocalDataSource: BooksLocalDataSource
    ): BooksRepository {
        return BooksRepositoryImpl(
            booksRemoteDataSource,
            booksLocalDataSource
        )
    }

}














