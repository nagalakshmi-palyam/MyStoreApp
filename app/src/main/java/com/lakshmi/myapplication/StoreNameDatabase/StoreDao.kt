package com.lakshmi.myapplication.StoreNameDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lakshmi.myapplication.RoomDatabse.Products

@Dao
interface StoreDao {
    @Insert
    suspend fun insertBusinessname(storeName:Store)
    @Query("Select * From store")
    fun getStoreName(): LiveData<List<Store>>
}