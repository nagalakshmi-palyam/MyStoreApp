package com.lakshmi.myapplication.DatabaseForCollectionFragment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lakshmi.myapplication.RoomDatabse.ProductDao
import com.lakshmi.myapplication.RoomDatabse.ProductDatabase
import com.lakshmi.myapplication.RoomDatabse.Products

@Database(entities = [Collection::class], version = 2, exportSchema = false)
abstract class CollectionDatabase: RoomDatabase() {
    abstract val collectionDao: CollectionDao
    companion object{
        private var INSTANCE: CollectionDatabase? = null
        fun getInstance(context: Context): CollectionDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, CollectionDatabase::class.java, "collection_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}