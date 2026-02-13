package com.example.internshiptask2

import android.app.Application
import androidx.room.Room
import com.example.internshiptask2.data.local.AppDatabase

class MyApp : Application() {

    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
}
