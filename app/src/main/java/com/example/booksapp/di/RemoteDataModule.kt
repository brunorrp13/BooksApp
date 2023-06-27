package com.example.booksapp.di

import com.example.booksapp.data.api.BooksAPIService
import com.example.booksapp.data.repository.dataSource.BooksRemoteDataSource
import com.example.booksapp.data.repository.dataSourceImpl.BooksRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideBooksRemoteDataSource(
        booksAPIService: BooksAPIService
    ):BooksRemoteDataSource{
       return BooksRemoteDataSourceImpl(booksAPIService)
    }
}
