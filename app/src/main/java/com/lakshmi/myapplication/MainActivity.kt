package com.lakshmi.myapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.lakshmi.myapplication.RoomDatabse.ProductViewModel
import com.lakshmi.myapplication.RoomDatabse.ProductViewModelFactory
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {
    private var list = emptyList<Products>()
    private lateinit var productViewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        productViewModel=ProductViewModelFactory(this).create(ProductViewModel::class.java)
      //  fetchdb()
    }
    fun fetchdb(){
        productViewModel.fetchDataFromDB().observe(this,{
        it.let{
            for(i in 0 until it.size){
                name.text=it.get(i).productname
                product.setImageURI(Uri.parse(it.get(i).productimage))
            }
        }
        })
    }
}