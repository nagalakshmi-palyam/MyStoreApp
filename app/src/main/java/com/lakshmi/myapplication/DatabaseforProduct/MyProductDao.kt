package com.lakshmi.myapplication.DatabaseforProduct

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lakshmi.myapplication.RoomDatabse.Products
@Dao
interface MyProductDao {
    @Insert
    suspend fun insertProducts(products: CatogoryProduct)
    @Query("Select * From myProduct")
    fun getAllProducts(): LiveData<List<CatogoryProduct>>
}