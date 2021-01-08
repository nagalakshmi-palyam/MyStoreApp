package com.lakshmi.myapplication.RoomDatabse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.R

class ProductAdapter(private var productlist:List<Products>):
    RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view= LayoutInflater.from(parent.context).
        inflate(R.layout.products_item_layout,parent,false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data=productlist[position]
        holder.setData(data)

    }

    override fun getItemCount(): Int {
       return  productlist.size
    }
    fun updateList(productlist: List<Products>){
     this.productlist=productlist
     notifyDataSetChanged()
    }
}