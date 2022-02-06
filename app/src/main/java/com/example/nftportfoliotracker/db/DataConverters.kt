package com.example.nftportfoliotracker.db

import androidx.room.TypeConverter
import com.example.nftportfoliotracker.model.MainResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class DataConverters {
    @TypeConverter
    fun stringToIntList(data: String?): List<Int>? {
        return data?.let {
            it.split(",").map {
                try {
                    it.toInt()
                } catch (ex: NumberFormatException) {
                    null
                }
            }
        }?.filterNotNull()
    }

    @TypeConverter
    fun intListToString(ints: List<Int>?): String? {
        return ints?.joinToString(",")
    }

    //Home Cards
    @TypeConverter
    fun fromHomeCard(value: List<MainResponse>?): String? {
        if (value == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<MainResponse>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toHomeCard(valueString: String?): List<MainResponse>? {
        if (valueString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<MainResponse>?>() {}.type
        return gson.fromJson(valueString, type)
    }



    @TypeConverter
    fun fromString(stringListString: String?): List<String>? {
        return stringListString?.split(",")?.map { it }
    }

    @TypeConverter
    fun toString(stringList: List<String>?): String? {
        return stringList?.joinToString(separator = ",")
    }
}
