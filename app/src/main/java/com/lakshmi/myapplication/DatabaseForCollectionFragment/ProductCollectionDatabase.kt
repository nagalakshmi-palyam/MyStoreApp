//package com.lakshmi.myapplication.DatabaseForCollectionFragment
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//@Database(entities = [MyCollection::class, ProductsunderCategory::class], version = 1)
//abstract class ProductCollectionDatabase : RoomDatabase(){
//    abstract val collectionProductDao:CollectionProductDao
//    companion object{
//        private var INSTANCE: ProductCollectionDatabase? = null
//        fun getInstance(context: Context): ProductCollectionDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//                if (instance == null) {
//                    instance =
//                        Room.databaseBuilder(context,ProductCollectionDatabase::class.java, "productcollection_db").build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
//
//}