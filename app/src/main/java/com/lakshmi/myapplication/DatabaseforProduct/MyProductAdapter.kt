package com.lakshmi.myapplication.DatabaseforProduct

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.Listners.CollectionItemClickListener
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomDatabse.ProductViewHolder
import com.lakshmi.myapplication.RoomDatabse.Products

class MyProductAdapter(private var productlist:List<CatogoryProduct>,private var ItemclickListener:CollectionItemClickListener):
    RecyclerView.Adapter<MyProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductViewHolder {
        val view= LayoutInflater.from(parent.context).
        inflate(R.layout.products_item_layout,parent,false)
        return MyProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyProductViewHolder, position: Int) {
        val data=productlist[position]
        holder.setData(data)

    }

    override fun getItemCount(): Int {
        return  productlist.size
    }
    fun updateList(productlist: List<CatogoryProduct>){
        this.productlist=productlist
        notifyDataSetChanged()
    }
}