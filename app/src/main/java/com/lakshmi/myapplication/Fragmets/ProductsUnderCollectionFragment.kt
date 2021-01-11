package com.lakshmi.myapplication.Fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomDatabse.ProductAdapter
import com.lakshmi.myapplication.RoomDatabse.ProductViewModel
import com.lakshmi.myapplication.RoomDatabse.Products
import com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection.Productcategory
import com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection.ProductcategoryAdapter
import com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection.ProductcategoryViewModel
import com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection.ProductcategoryViewModelFactory
import kotlinx.android.synthetic.main.fragment_products_under_collection.*
import kotlinx.android.synthetic.main.fragment_productsragment.*

class ProductsUnderCollectionFragment : Fragment() {
    private var list = emptyList<Productcategory>()
    private lateinit var productcategoryViewModel: ProductcategoryViewModel
    private lateinit var productcategoryAdapter: ProductcategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products_under_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initviews(view)
    }
   fun initviews(view:View){
      productcategoryViewModel=ProductcategoryViewModelFactory(this.requireContext()).create(ProductcategoryViewModel::class.java)
       setAdapterandLayout()
       fetchproductsfromdatabase()
   }
    fun setAdapterandLayout(){
        val linearlayoutmanager = LinearLayoutManager(context)
        productcategoryAdapter= ProductcategoryAdapter(list)
        productrecycler.apply {
            this.layoutManager = linearlayoutmanager
            this.adapter=productcategoryAdapter
        }

    }
    fun fetchproductsfromdatabase(){
       productcategoryViewModel.fetchProductsDataFromDB().observe(this,{
           it.let{
               this.list=it
                   productcategoryAdapter.updateProducts(it)
           }
       })
    }
}