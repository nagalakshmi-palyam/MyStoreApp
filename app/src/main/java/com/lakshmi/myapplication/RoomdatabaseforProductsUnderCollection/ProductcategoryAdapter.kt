package com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomDatabse.ProductViewHolder
import com.lakshmi.myapplication.RoomDatabse.Products

class ProductcategoryAdapter(private var list:List<Productcategory>):
    RecyclerView.Adapter<ProductCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        val view= LayoutInflater.from(parent.context).
        inflate(R.layout.productcategory_items,parent,false)
        return ProductCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductCategoryViewHolder, position: Int) {
        var data=list[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
       return list.size
    }
    fun updateProducts(list:List<Productcategory>){
        this.list=list
        notifyDataSetChanged()
    }
}