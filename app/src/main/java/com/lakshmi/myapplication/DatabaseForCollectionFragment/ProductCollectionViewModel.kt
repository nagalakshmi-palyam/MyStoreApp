package com.lakshmi.myapplication.DatabaseForCollectionFragment

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductCollectionViewModel(private val context: Context): ViewModel()  {
//    fun insertDatatoDatabase(categoryname:String,image:String,myproductCount:String){
//        CoroutineScope(Dispatchers.IO).launch {
//            val collection=
//                Lakshmi(
//                    categoryname=categoryname,categoryimage=image,productcountnumbers = myproductCount,categoryid = )
//            ProductCollectionDatabase.getInstance(context).collectionProductDao.insercategory(collection)
//        }
//    }
//    fun fetchDataFromDB(): LiveData<List<MyCollection>> {
//        return CollectionDatabase.getInstance(context)
//            .collectionDao.getAllCollections()
//    }
}