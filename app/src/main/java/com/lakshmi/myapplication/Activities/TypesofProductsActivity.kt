package com.lakshmi.myapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakshmi.myapplication.Adapters.ItemAdapter
import com.lakshmi.myapplication.Listners.ItemClickListner
import com.lakshmi.myapplication.Model.ItemModel
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.activity_typesof_products.*

class TypesofProductsActivity : AppCompatActivity(),ItemClickListner, View.OnClickListener {
   private var mybusiness:String=""
    private var producttype1:String=""
   private var listitems:MutableList<ItemModel> = mutableListOf()
    private lateinit var itemAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_typesof_products)
        bindItemData()
        setAdapterandLayout()
        mybusiness= intent.getStringExtra("business").toString()
        btnaddProduct.setOnClickListener(this)
    }
    fun bindItemData(){
        listitems.add(ItemModel("Fashion Jewelary",R.drawable.arnament,""))
        listitems.add(ItemModel("Cam/Photos/Phone",R.drawable.ic_cam,""))
        listitems.add(ItemModel("Games/Sports",R.drawable.ic_sports,""))
        listitems.add(ItemModel("Furniture",R.drawable.ic_furniture,""))
        listitems.add(ItemModel("Restaurent ",R.drawable.ic_restaurant,""))
        listitems.add(ItemModel("Grocery ",R.drawable.ic_grocery,""))
        listitems.add(ItemModel("Musical Instruments ",R.drawable.ic_music,""))

    }
    fun setAdapterandLayout(){
        val linearLayoutmanager = LinearLayoutManager(this)
        itemAdapter= ItemAdapter(listitems,this)
        itemRecyclerView.apply {
            this.layoutManager=linearLayoutmanager
            this.adapter=itemAdapter
        }
    }
    override fun onItemClicked(itemModel: ItemModel, Position: Int) {
        producttype1=itemModel.itemName

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnaddProduct->{
                val intent = Intent(this@TypesofProductsActivity, StoreProfile::class.java)
                intent.putExtra("itemname",producttype1)
                intent.putExtra("businesname",mybusiness)
                startActivity(intent)
            }

        }
    }
}