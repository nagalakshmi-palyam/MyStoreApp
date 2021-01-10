package com.lakshmi.myapplication.DatabaseforProduct

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lakshmi.myapplication.RoomDatabse.ProductDatabase
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyProductViewModel(private val context: Context): ViewModel() {
    fun insertDatatoDatabase(myproductName:String,mymrp:String,mysellingPrice:String,myselectUnit:String,
                             myaddDesrciption:String,mychooseCategory:String,myproductImage:String,mydiscount:String ){
        CoroutineScope(Dispatchers.IO).launch {
            val product =
                CatogoryProduct(myproductname= myproductName,mymrp=mymrp,mysellingprice = mysellingPrice,
                    myselectunit = myselectUnit,myaddproductdescription = myaddDesrciption,
                    mychoosecategory = mychooseCategory,myproductimage = myproductImage,mydiscount = mydiscount)
            MyCategoryDatabase.getInstance(context).mycategorydao.insertProducts(product)
        }
    }
    fun fetchDataFromDB(): LiveData<List<CatogoryProduct>> {
        return MyCategoryDatabase.getInstance(context)
            .mycategorydao.getAllProducts()
    }
}
