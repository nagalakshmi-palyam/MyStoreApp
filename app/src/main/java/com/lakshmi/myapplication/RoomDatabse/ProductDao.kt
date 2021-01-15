package com.lakshmi.myapplication.RoomDatabse

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection.Productcategory

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProducts(products: Products)
    @Query("Select * From Product")
    fun getAllProducts(): LiveData<List<Products>>
    @Query("Select * From Product where productname= :searchproductName")
    fun getSearchProducts(searchproductName:String): LiveData<List<Products>>
    @Delete
    fun deleteProducts(products:Products)
}