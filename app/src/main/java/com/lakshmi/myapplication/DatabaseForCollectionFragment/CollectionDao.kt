package com.lakshmi.myapplication.DatabaseForCollectionFragment

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lakshmi.myapplication.RoomDatabse.Products

@Dao
interface CollectionDao {
    @Insert
    suspend fun insertCollections(collections:Collection)
    @Query("Select * From collection")
    fun getAllCollections(): LiveData<List<Collection>>
}