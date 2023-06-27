package com.example.booksapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.booksapp.domain.usecase.*

class BooksViewModelFactory(
    private val app:Application,
    private val getBooksUseCase: GetBooksUseCase,
    private val saveBooksUseCase: SaveBooksUseCase,
    private val getSavedBooksUseCase: GetSavedBooksUseCase,
    private val deleteSavedBooksUseCase: DeleteSavedBooksUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BooksViewModel(
            app,
            getBooksUseCase,
            saveBooksUseCase,
            getSavedBooksUseCase,
            deleteSavedBooksUseCase
        ) as T
    }
}









