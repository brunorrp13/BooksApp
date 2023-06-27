package com.example.booksapp.data.db

import androidx.room.TypeConverter
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
}
