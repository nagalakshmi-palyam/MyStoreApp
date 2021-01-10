package com.lakshmi.myapplication.DatabaseForCollectionFragment

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.Listners.CollectionItemClickListener
import kotlinx.android.synthetic.main.collections_layout.view.*

class CollectionViewHolder(val view:View,private var itemClickListener: CollectionItemClickListener): RecyclerView.ViewHolder(view) {
    fun setData(collections:Collection,position:Int){
       view.apply{
           ivimagecollection.setImageURI(Uri.parse(collections.collectionimage))
            tvcollectionname.text=collections.collectionname
           tvcollectionname.setOnClickListener {
               itemClickListener.onItemClicked(collections,position)
           }
       }
    }
}