package com.example.booksapp.di

import com.example.booksapp.domain.repository.BooksRepository
import com.example.booksapp.domain.usecase.DeleteSavedBooksUseCase
import com.example.booksapp.domain.usecase.GetBooksUseCase
import com.example.booksapp.domain.usecase.GetSavedBooksUseCase
import com.example.booksapp.domain.usecase.SaveBooksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetBooksUseCase(
        booksRepository: BooksRepository
    ): GetBooksUseCase {
        return GetBooksUseCase(booksRepository)
    }

    @Singleton
    @Provides
    fun provideSaveBooksUseCase(
        booksRepository: BooksRepository
    ): SaveBooksUseCase {
        return SaveBooksUseCase(booksRepository)
    }

    @Singleton
    @Provides
    fun provideGetSavedBooksUseCase(
        booksRepository: BooksRepository
    ): GetSavedBooksUseCase {
        return GetSavedBooksUseCase(booksRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteSavedBooksUseCase(
        booksRepository: BooksRepository
    ): DeleteSavedBooksUseCase {
        return DeleteSavedBooksUseCase(booksRepository)
    }
}
