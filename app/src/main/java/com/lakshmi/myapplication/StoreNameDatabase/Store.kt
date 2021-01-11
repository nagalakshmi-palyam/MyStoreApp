package com.lakshmi.myapplication.StoreNameDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "store")
data class Store (
    @PrimaryKey(autoGenerate = true)
    var storeId: Int = 0,

    @ColumnInfo(name = "businessName")
    val businessName: String,
    @ColumnInfo(name = "storeName")
    val storeName: String
)