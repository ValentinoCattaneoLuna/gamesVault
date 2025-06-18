package com.example.gamesvault.data.local

import androidx.room.TypeConverter
import com.example.gamesvault.data.ReqMin
import com.example.gamesvault.data.Screenshot
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromReqMin(reqMin: ReqMin): String {
        return Gson().toJson(reqMin)
    }

    @TypeConverter
    fun toReqMin(json: String): ReqMin {
        return Gson().fromJson(json, ReqMin::class.java)
    }

    @TypeConverter
    fun fromScreenshots(list: List<Screenshot>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toScreenshots(json: String): List<Screenshot> {
        return Gson().fromJson(json, object : TypeToken<List<Screenshot>>() {}.type)
    }
}