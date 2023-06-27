package com.example.booksapp.data.db

import androidx.room.TypeConverter
import com.example.booksapp.data.model.SaleInfo
import com.example.booksapp.data.model.VolumeInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromVolumeInfo(volumeInfo: VolumeInfo): String {
        return gson.toJson(volumeInfo)
    }

    @TypeConverter
    fun toVolumeInfo(json: String): VolumeInfo {
        val type = object : TypeToken<VolumeInfo>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromSalesInfo(saleInfo: SaleInfo): String {
        return gson.toJson(saleInfo)
    }

    @TypeConverter
    fun toSalesInfo(json: String): SaleInfo {
        val type = object : TypeToken<SaleInfo>() {}.type
        return gson.fromJson(json, type)
    }
}
