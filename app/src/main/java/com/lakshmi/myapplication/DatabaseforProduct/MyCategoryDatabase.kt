package com.lakshmi.myapplication.DatabaseforProduct

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lakshmi.myapplication.RoomDatabse.ProductDao
import com.lakshmi.myapplication.RoomDatabse.ProductDatabase
import com.lakshmi.myapplication.RoomDatabse.Products

@Database(entities = [CatogoryProduct::class], version = 1, exportSchema = false)
abstract class MyCategoryDatabase: RoomDatabase() {
    abstract val mycategorydao:MyProductDao
    companion object{
        private var INSTANCE: MyCategoryDatabase? = null
        fun getInstance(context: Context): MyCategoryDatabase{
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, MyCategoryDatabase::class.java, "myproduct_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}