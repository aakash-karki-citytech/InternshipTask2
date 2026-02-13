package com.example.internshiptask2.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class SettingEntity(
    @PrimaryKey(autoGenerate = true)
    val key: Int = 0,
    val title: String,
    val value: String
)

