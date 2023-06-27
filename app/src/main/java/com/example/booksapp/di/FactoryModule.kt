package com.example.booksapp.di

import android.app.Application
import com.example.booksapp.domain.usecase.DeleteSavedBooksUseCase
import com.example.booksapp.domain.usecase.GetBooksUseCase
import com.example.booksapp.domain.usecase.GetSavedBooksUseCase
import com.example.booksapp.domain.usecase.SaveBooksUseCase
import com.example.booksapp.ui.viewmodel.BooksViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
  fun provideBooksViewModelFactory(
     application: Application,
     getBooksUseCase: GetBooksUseCase,
     saveBooksUseCase: SaveBooksUseCase,
     getSavedBooksUseCase: GetSavedBooksUseCase,
     deleteSavedBooksUseCase: DeleteSavedBooksUseCase
  ):BooksViewModelFactory{
      return BooksViewModelFactory(
          application,
          getBooksUseCase,
          saveBooksUseCase,
          getSavedBooksUseCase,
          deleteSavedBooksUseCase
      )
  }
}
