package com.lakshmi.myapplication.StoreNameDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Store::class], version = 1, exportSchema = false)
abstract class StoreDatabase:RoomDatabase() {
    abstract val storeDao:StoreDao
    companion object{
        private var INSTANCE: StoreDatabase? = null
        fun getInstance(context: Context): StoreDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, StoreDatabase::class.java, "store_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}