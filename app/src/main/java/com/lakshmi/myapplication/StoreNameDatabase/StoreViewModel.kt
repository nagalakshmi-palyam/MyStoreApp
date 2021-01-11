package com.lakshmi.myapplication.StoreNameDatabase

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lakshmi.myapplication.ProfileRoomdatabase.StoreProfileDatabase
import com.lakshmi.myapplication.ProfileRoomdatabase.StoreProfileandImage
import com.lakshmi.myapplication.RoomDatabse.ProductDatabase
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoreViewModel(private val context: Context): ViewModel()  {
    fun insertStoretoDatabase(businessName:String,storeName:String){
        CoroutineScope(Dispatchers.IO).launch {
            val store = Store(businessName = businessName,storeName = storeName)
            StoreDatabase.getInstance(context).storeDao.insertBusinessname(store)
        }
    }
    fun fetchDataFromDB(): LiveData<List<Store>> {
        return StoreDatabase.getInstance(context)
            .storeDao.getStoreName()
    }
    fun inserprofiletoDatabase(stoprofileImage:String,businesstype:String){
        CoroutineScope(Dispatchers.IO).launch {
         val storeprofile=StoreProfileandImage(profilepic=stoprofileImage,businessType=businesstype)
            StoreProfileDatabase.getInstance(context).storeProfileDao.insertImageandType(storeprofile)
        }
    }
    fun fetchProfileFromDB(): LiveData<List<StoreProfileandImage>> {
        return StoreProfileDatabase.getInstance(context).storeProfileDao.getImageandType()
    }
}