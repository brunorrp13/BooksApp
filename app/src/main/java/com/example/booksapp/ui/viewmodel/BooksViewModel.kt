package com.example.booksapp.ui.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.example.booksapp.data.model.APIResponse
import com.example.booksapp.data.model.Item
import com.example.booksapp.data.util.Resource
import com.example.booksapp.domain.usecase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class BooksViewModel(
    private val app: Application,
    private val getBooksUseCase: GetBooksUseCase,
    private val getSearchedBooksUseCase: GetSearchedBooksUseCase,
    private val saveBooksUseCase: SaveBooksUseCase,
    private val getSavedBooksUseCase: GetSavedBooksUseCase,
    private val deleteSavedBooksUseCase: DeleteSavedBooksUseCase
) : AndroidViewModel(app) {
    val books: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getBooks(isbn: String) = viewModelScope.launch(Dispatchers.IO) {
        books.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {

                val apiResult = getBooksUseCase.execute(isbn)
                books.postValue(apiResult)
            } else {
                books.postValue(Resource.Error("Internet is not available"))
            }

        } catch (e: Exception) {
            books.postValue(Resource.Error(e.message.toString()))
        }
    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }

    //search
    private val searchedBooks: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

//    fun searchBooks(
//        country: String,
//        searchQuery: String,
//        page: Int
//    ) = viewModelScope.launch {
//        searchedBooks.postValue(Resource.Loading())
//        try {
//            if (isNetworkAvailable(app)) {
//                val response = getSearchedBooksUseCase.execute(
//                    country,
//                    searchQuery,
//                    page
//                )
//                searchedBooks.postValue(response)
//            } else {
//                searchedBooks.postValue(Resource.Error("No internet connection"))
//            }
//        } catch (e: Exception) {
//            searchedBooks.postValue(Resource.Error(e.message.toString()))
//        }
//    }

    //local data
    fun saveBook(book: Item) = viewModelScope.launch {
        saveBooksUseCase.execute(book)
    }

    fun getSavedBooks() = liveData {
        getSavedBooksUseCase.execute().collect {
            emit(it)
        }
    }

    fun deleteBook(book: Item) = viewModelScope.launch {
        deleteSavedBooksUseCase.execute(book)
    }
}
