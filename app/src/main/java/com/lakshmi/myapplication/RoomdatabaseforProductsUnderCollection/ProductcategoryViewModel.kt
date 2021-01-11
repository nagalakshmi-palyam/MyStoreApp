package com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lakshmi.myapplication.RoomDatabse.ProductDatabase
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductcategoryViewModel(private val context: Context): ViewModel() {
    fun insertProductsDatatoDatabase(Name:String,mrp:String,Price:String,productImage:String,discount:String,){
        CoroutineScope(Dispatchers.IO).launch {
            val productscategory=Productcategory(categorproductname = Name,categormrp = mrp,categorsellingprice = Price,categorproductimage = productImage,categordiscount =discount )
            ProductCatogoryDatabase.getInstance(context).productCategoryDao.insertProductscategory(productscategory)
        }
    }
    fun fetchProductsDataFromDB(): LiveData<List<Productcategory>> {
        return ProductCatogoryDatabase.getInstance(context)
            .productCategoryDao.getAllProductcategory()
    }
}