package com.example.internshiptask2.data.repository

import android.content.Context
import com.example.internshiptask2.data.model.HeritageSite
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeritageRepository(private val context: Context) {
    fun getHeritageSites(): List<HeritageSite> {
        val jsonString = context.assets.open("heritage.json").bufferedReader().use { it.readText() }

        val gson = Gson()
        val type = object : TypeToken<List<HeritageSite>>() {}.type

        return gson.fromJson(jsonString, type)
    }
}