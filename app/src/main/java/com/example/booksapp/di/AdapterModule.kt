package com.example.booksapp.di

import com.example.booksapp.ui.adapter.BooksAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
   @Singleton
   @Provides
   fun provideBooksAdapter():BooksAdapter{
       return BooksAdapter()
   }
}