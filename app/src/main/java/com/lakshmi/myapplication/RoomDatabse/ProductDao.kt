package com.lakshmi.myapplication.RoomDatabse

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface ProductDao {
    @Insert
    suspend fun insertProducts(products: Products)
    @Query("Select * From Product")
    fun getAllProducts(): LiveData<List<Products>>
}