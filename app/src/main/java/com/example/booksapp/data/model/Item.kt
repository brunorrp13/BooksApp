package com.example.booksapp.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName = "books"
)
data class Item(
    @PrimaryKey()
    @SerializedName("id")
    val id: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("selfLink")
    val selfLink: String,
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo,
    @SerializedName("saleInfo")
    val saleInfo: SaleInfo,
): Serializable