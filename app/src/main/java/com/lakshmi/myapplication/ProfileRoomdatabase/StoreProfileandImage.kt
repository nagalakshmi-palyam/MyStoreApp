package com.lakshmi.myapplication.ProfileRoomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "storeimage")
data class StoreProfileandImage (
    @PrimaryKey(autoGenerate = true)
    var storeimageid: Int = 0,
    @ColumnInfo(name = "profilepic")
    val profilepic: String,
    @ColumnInfo(name = "businessType")
    val businessType: String
)