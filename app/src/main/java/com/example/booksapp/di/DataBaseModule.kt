package com.example.booksapp.di

import android.app.Application
import androidx.room.Room
import com.example.booksapp.data.db.BooksDAO
import com.example.booksapp.data.db.BooksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideBooksDatabase(app: Application): BooksDatabase {
        return Room.databaseBuilder(app, BooksDatabase::class.java, "books_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBooksDao(booksDatabase: BooksDatabase): BooksDAO {
        return booksDatabase.getBooksDAO()
    }
}