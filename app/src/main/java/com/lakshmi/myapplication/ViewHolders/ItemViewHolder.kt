package com.lakshmi.myapplication.ViewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.Listners.ItemClickListner
import com.lakshmi.myapplication.Model.ItemModel
import kotlinx.android.synthetic.main.storeproducts_item_layout.view.*

class ItemViewHolder(private val view:View,private var itemClickListner:
ItemClickListner):RecyclerView.ViewHolder(view) {
fun setData(itemModel:ItemModel,position:Int){
view.apply{
    tvItemname.text=itemModel.itemName
    ivItemimage.setImageResource(itemModel.itemImage)
    checkbox.setOnClickListener {
        itemClickListner.onItemClicked(itemModel,position)
    }
}
}
}