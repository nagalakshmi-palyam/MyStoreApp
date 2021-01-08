package com.lakshmi.myapplication.RoomDatabse

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.Format

class ProductViewModel(private val context: Context):ViewModel() {
fun insertDatatoDatabase(productName:String,mrp:String,sellingPrice:String,selectUnit:String,
                         addDesrciption:String,chooseCategory:String,productImage:String,discount:String ){
    CoroutineScope(Dispatchers.IO).launch {
        val product =
            Products(productname = productName,mrp=mrp,sellingprice = sellingPrice,
                selectunit = selectUnit,addproductdescription = addDesrciption,
                choosecategory = chooseCategory,productimage = productImage,discount = discount)
        ProductDatabase.getInstance(context).productDao.insertProducts(product)
    }
}
    fun fetchDataFromDB(): LiveData<List<Products>> {
        return ProductDatabase.getInstance(context)
            .productDao.getAllProducts()
    }

    private var discount:Float=0.0f
    fun discountCalculate(mrp: Float,sellingPrice:Float){
        discount=((mrp-sellingPrice)/mrp)*100
    }
    fun getDiscount(): Float {
        return discount
    }
}