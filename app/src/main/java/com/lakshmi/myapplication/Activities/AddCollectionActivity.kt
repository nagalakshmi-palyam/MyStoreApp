package com.lakshmi.myapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakshmi.myapplication.DatabaseForCollectionFragment.Collection
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionAdapter
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionViewModel
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionViewModelFactory
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomDatabse.ProductAdapter
import com.lakshmi.myapplication.RoomDatabse.ProductViewModel
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.android.synthetic.main.activity_next_collection.*
import kotlinx.android.synthetic.main.fragment_productsragment.*

class AddCollectionActivity : AppCompatActivity(), View.OnClickListener{
    private var category:String=""
    private var list = emptyList<Collection>()
    private lateinit var collectionViewModel: CollectionViewModel
    private lateinit var collectionAdapter: CollectionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_collection)
        collectionViewModel= CollectionViewModelFactory(this).create(CollectionViewModel::class.java)
        setAdapterandLayout()
        fetchfromDatabase()
        initviews()
    }
    fun initviews(){
        backArrowtoAddProducts.setOnClickListener(this)
        btnaddcategory.setOnClickListener(this)
        ivplus.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backArrowtoAddProducts->{
                val intent = Intent(this@AddCollectionActivity, AddProduct::class.java)
                startActivity(intent)
            }
            R.id.btnaddcategory->{
                val intent = Intent(this@AddCollectionActivity, HomeActivity::class.java)
                intent.putExtra("Category",category)
                startActivity(intent)
            }
            R.id.ivplus->{
                val intent = Intent(this@AddCollectionActivity, CollectionName::class.java)
                startActivity(intent)
            }
        }
    }
   private fun setAdapterandLayout(){
        val linearlayoutmanager = LinearLayoutManager(this)
        collectionAdapter= CollectionAdapter(list)
        collectionrecyclerview.apply {
            this.layoutManager = linearlayoutmanager
            this.adapter=collectionAdapter
        }
    }
  private  fun fetchfromDatabase(){
        collectionViewModel.fetchDataFromDB().observe(this,{
            it.let{
                this.list=it
                collectionAdapter.updateList(it)
                for(i in 0 until it.size) {
                    category = it[i].collectionname
                }
            }
        })

    }
}