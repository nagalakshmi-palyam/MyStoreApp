package com.lakshmi.myapplication.DatabaseForCollectionFragment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collection")
data class Collection (
    @PrimaryKey(autoGenerate = true)
    var collectionId: Int = 0,
    @ColumnInfo(name = "collectionname")
    val collectionname: String,
    @ColumnInfo(name = "collectionimage")
    val collectionimage: String,
    @ColumnInfo(name = "productCount")
    val productCount: String
)