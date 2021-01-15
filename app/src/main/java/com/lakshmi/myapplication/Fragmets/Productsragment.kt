package com.lakshmi.myapplication.Fragmets

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakshmi.myapplication.Activities.AddProduct
import com.lakshmi.myapplication.Listners.ProductItemClicklistner
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomDatabse.ProductAdapter
import com.lakshmi.myapplication.RoomDatabse.ProductViewModel
import com.lakshmi.myapplication.RoomDatabse.ProductViewModelFactory
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.android.synthetic.main.fragment_productsragment.*

class Productsragment : Fragment() ,View.OnClickListener,ProductItemClicklistner{
    private var name=""
    private var mrp=""
    private var sellingprice=""
    private var selectunit=""
    private var addproductdescription=""
    private var choosecategory=""
    private var productimage=""
    private var discount=""
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
    fun initviews(view: View){
        productViewModel= ProductViewModelFactory(this.requireContext()).create(ProductViewModel::class.java)
        setAdapterandLayout()
        fetchfromDatabase()
        searchproducts.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchProductsFromdatabase(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        btnaddfragmentproduct.setOnClickListener(this)
    }
 fun setAdapterandLayout(){
     val linearlayoutmanager = LinearLayoutManager(context)
     productAdapter= ProductAdapter(list,this)
     recyclerview.apply {
         this.layoutManager = linearlayoutmanager
         this.adapter=productAdapter
     }
 }
    fun fetchfromDatabase(){
        productViewModel.fetchDataFromDB().observe(this, {
            it.let {
                this.list = it
                productAdapter.updateList(it)
                for(i in 0 until it.size){
                    name=it[i].productname
                    mrp=it[i].mrp
                    sellingprice=it[i].sellingprice
                    selectunit=it[i].selectunit
                    addproductdescription=it[i].addproductdescription
                    choosecategory=it[i].choosecategory
                    productimage=it[i].productimage
                    discount=it[i].discount

                }
            }
        })

    }
    fun searchProductsFromdatabase(myProductName:String){
        productViewModel.searchDataFromDB(myProductName).observe(this,{
            it.let {
                this.list=it
                productAdapter.updateList(it)
            }
        })
    }
    fun deletefromdatabase(){
        productViewModel.deleteFromDatabase(name,mrp,sellingprice,selectunit,addproductdescription,choosecategory,productimage,discount)
    }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.btnaddfragmentproduct->{
                val intent=Intent(requireContext(),AddProduct::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onProductClicked(itemModel: Products, Position: Int) {
        Toast.makeText(requireContext(),"On discount clickeked",Toast.LENGTH_SHORT).show()
        deletefromdatabase()
    }
}