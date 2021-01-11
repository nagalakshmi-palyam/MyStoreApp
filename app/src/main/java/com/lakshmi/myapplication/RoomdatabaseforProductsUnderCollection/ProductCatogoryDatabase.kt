package com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Productcategory::class], version = 1, exportSchema = false)
abstract class ProductCatogoryDatabase: RoomDatabase() {
    abstract val productCategoryDao:ProductCategoryDao
    companion object{
        private var INSTANCE: ProductCatogoryDatabase? = null
        fun getInstance(context: Context): ProductCatogoryDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, ProductCatogoryDatabase::class.java, "productcategory_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}