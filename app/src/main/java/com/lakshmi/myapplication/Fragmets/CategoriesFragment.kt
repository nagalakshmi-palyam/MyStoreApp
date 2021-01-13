package com.lakshmi.myapplication.Fragmets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakshmi.myapplication.Activities.AddCollectionActivity
import com.lakshmi.myapplication.DatabaseForCollectionFragment.Collection
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionAdapter
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionViewModel
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionViewModelFactory
import com.lakshmi.myapplication.Listners.CollectionItemClickListener
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection.ProductcategoryViewModel
import com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection.ProductcategoryViewModelFactory
import kotlinx.android.synthetic.main.activity_next_collection.*
import kotlinx.android.synthetic.main.activity_next_collection.searchproducts
import kotlinx.android.synthetic.main.fragment_categories.*
import kotlinx.android.synthetic.main.fragment_productsragment.*

class CategoriesFragment : Fragment(),CollectionItemClickListener,View.OnClickListener{
    private var nameCollection:String=""
    private var list = emptyList<Collection>()
    private lateinit var collectionViewModel: CollectionViewModel
    private lateinit var collectionAdapter: CollectionAdapter
    private lateinit var productcategoryViewModel: ProductcategoryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectionViewModel= CollectionViewModelFactory(requireContext()).create(CollectionViewModel::class.java)
        productcategoryViewModel=ProductcategoryViewModelFactory(requireContext()).create(ProductcategoryViewModel::class.java)
        initviews(view)
    }
    fun initviews(view:View){
        setAdapterandLayout()
        fetchfromDatabase()
        searchCollections.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
               searchCollectionFromDatabase(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        btnaddcategoryfragment.setOnClickListener(this)
    }
    fun setAdapterandLayout(){
        val linearlayoutmanager = LinearLayoutManager(context)
        collectionAdapter= CollectionAdapter(list,this)
        recyclercollectionfragment.apply {
            this.layoutManager = linearlayoutmanager
            this.adapter=collectionAdapter
        }
    }
    fun fetchfromDatabase(){
        collectionViewModel.fetchDataFromDB().observe(this,{
            it.let{
                this.list=it
                collectionAdapter.updateList(it)
                for(i in 0 until it.size) {
                    nameCollection=it[i].collectionname
                }
            }
        })

    }
    fun searchCollectionFromDatabase(name:String){
        collectionViewModel.fetchcollectionFromDB(name).observe(this,{
         this.list=it
            collectionAdapter.updateList(it)
        })

    }

    override fun onItemClicked(itemModel: Collection, Position: Int) {
       // productcategoryViewModel.collection.value=nameCollection
//        Toast.makeText(
//            requireContext(),
//            "Category :"+nameCollection, Toast.LENGTH_SHORT
//        ).show()
        val productfragment = ProductsUnderCollectionFragment()
        val bundle = Bundle()
        bundle.putString("data",itemModel.collectionname)
        productfragment.arguments = bundle
        activity?.let {
            it.supportFragmentManager.beginTransaction().replace(R.id.fragment_Container,productfragment).addToBackStack("ProductUnserCollection").commit()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnaddcategoryfragment->{
                val intent= Intent(requireContext(),AddCollectionActivity::class.java)
                startActivity(intent)
            }
        }
    }

}