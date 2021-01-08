package com.lakshmi.myapplication.DatabaseForCollectionFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomDatabse.ProductViewHolder
import com.lakshmi.myapplication.RoomDatabse.Products

class CollectionAdapter(private var collectionlist:List<Collection>)
    : RecyclerView.Adapter<CollectionViewHolder>(){
    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        val data=collectionlist[position]
        holder.setData(data)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view= LayoutInflater.from(parent.context).
        inflate(R.layout.collections_layout,parent,false)
        return CollectionViewHolder(view)
    }

    override fun getItemCount(): Int {
     return collectionlist.size
    }
    fun updateList(collectionlist: List<Collection>){
        this.collectionlist=collectionlist
        notifyDataSetChanged()
    }
}