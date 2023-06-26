package com.example.booksapp.data.model


import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)