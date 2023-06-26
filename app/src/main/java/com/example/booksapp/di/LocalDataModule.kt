package com.example.booksapp.di

import com.example.booksapp.data.db.BooksDAO
import com.example.booksapp.data.repository.dataSource.BooksLocalDataSource
import com.example.booksapp.data.repository.dataSourceImpl.BooksLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(booksDAO: BooksDAO): BooksLocalDataSource {
        return BooksLocalDataSourceImpl(booksDAO)
    }
}
