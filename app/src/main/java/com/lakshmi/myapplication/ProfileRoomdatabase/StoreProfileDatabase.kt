package com.lakshmi.myapplication.ProfileRoomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [StoreProfileandImage::class], version = 1, exportSchema = false)
abstract class StoreProfileDatabase:RoomDatabase() {
    abstract val storeProfileDao:StoreProfileDao
    companion object{
        private var INSTANCE: StoreProfileDatabase? = null
        fun getInstance(context: Context): StoreProfileDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, StoreProfileDatabase::class.java, "storeprofile_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}