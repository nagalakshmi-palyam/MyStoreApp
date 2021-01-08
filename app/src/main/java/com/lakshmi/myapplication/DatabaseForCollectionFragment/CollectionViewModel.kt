package com.lakshmi.myapplication.DatabaseForCollectionFragment

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lakshmi.myapplication.RoomDatabse.ProductDatabase
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CollectionViewModel(private val context: Context): ViewModel()  {
    fun insertDatatoDatabase(categoryName:String,imageUri:String,productCount:String){
        CoroutineScope(Dispatchers.IO).launch {
           val collection=Collection(collectionname = categoryName,collectionimage = imageUri,
               productCount = productCount)
            CollectionDatabase.getInstance(context).collectionDao.insertCollections(collection)
        }
    }
    fun fetchDataFromDB(): LiveData<List<Collection>> {
        return CollectionDatabase.getInstance(context)
            .collectionDao.getAllCollections()
    }
}