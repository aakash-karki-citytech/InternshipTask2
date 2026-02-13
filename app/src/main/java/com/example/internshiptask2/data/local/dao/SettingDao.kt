package com.example.internshiptask2.data.local.dao

import androidx.room.*
import com.example.internshiptask2.data.local.entity.SettingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingDao {

    @Query("SELECT * FROM settings")
    fun getAllSettings(): Flow<List<SettingEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSetting(setting: SettingEntity)

    @Delete
    suspend fun deleteSetting(setting: SettingEntity)
}
