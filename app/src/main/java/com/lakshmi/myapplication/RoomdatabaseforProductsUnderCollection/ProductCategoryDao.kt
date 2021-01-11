package com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lakshmi.myapplication.RoomDatabse.Products

@Dao
interface ProductCategoryDao {
    @Insert
    suspend fun insertProductscategory(productcategory: Productcategory)
    @Query("Select * From mycategory")
    fun getAllProductcategory(): LiveData<List<Productcategory>>
}