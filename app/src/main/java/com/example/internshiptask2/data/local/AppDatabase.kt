package com.example.internshiptask2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.internshiptask2.data.local.dao.SettingDao
import com.example.internshiptask2.data.local.entity.SettingEntity


@Database(
    entities = [SettingEntity::class, ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun settingDao(): SettingDao

}
