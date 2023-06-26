package com.example.booksapp.data.api

import com.example.booksapp.BuildConfig
import com.example.booksapp.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksAPIService {
  @GET("/books/v1/volumes")
  suspend fun getBooks(
      @Query("q")
      isbn:String,
      @Query("apiKey")
      apiKey:String = BuildConfig.API_KEY
  ): Response<APIResponse>
}