package com.lakshmi.myapplication.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.Listners.ItemClickListner
import com.lakshmi.myapplication.Model.ItemModel
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.ViewHolders.ItemViewHolder

class CollectionAdapter(private var itemlist:List<ItemModel>, private var listener: ItemClickListner):
    RecyclerView.Adapter<ItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view= LayoutInflater.from(parent.context).
        inflate(R.layout.storeproducts_item_layout,parent,false)
        return ItemViewHolder(view,listener)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data=itemlist[position]
        holder.setData(data,position)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}