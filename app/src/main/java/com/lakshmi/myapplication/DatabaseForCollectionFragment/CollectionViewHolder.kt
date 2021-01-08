package com.lakshmi.myapplication.DatabaseForCollectionFragment

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.collections_layout.view.*

class CollectionViewHolder(val view:View): RecyclerView.ViewHolder(view) {
    fun setData(collections:Collection){
       view.apply{
           ivimagecollection.setImageURI(Uri.parse(collections.collectionimage))
            tvcollectionname.text=collections.collectionname

       }
    }
}