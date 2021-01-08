package com.lakshmi.myapplication.Fragmets

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomDatabse.ProductAdapter
import com.lakshmi.myapplication.RoomDatabse.ProductViewModel
import com.lakshmi.myapplication.RoomDatabse.ProductViewModelFactory
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_productsragment.*

class Productsragment : Fragment() {
    private var list = emptyList<Products>()
    private lateinit var productViewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_productsragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initviews(view)
    }
    fun initviews(view:View){
        productViewModel= ProductViewModelFactory(this.requireContext()).create(ProductViewModel::class.java)
        setAdapterandLayout()
        fetchfromDatabase()
    }
 fun setAdapterandLayout(){
     val linearlayoutmanager = LinearLayoutManager(context)
     productAdapter= ProductAdapter(list)
     recyclerview.apply {
         this.layoutManager = linearlayoutmanager
         this.adapter=productAdapter
     }
 }
    fun fetchfromDatabase(){
        productViewModel.fetchDataFromDB().observe(this,{
            it.let{
              this.list=it
                productAdapter.updateList(it)
            }
        })

    }
}