package com.lakshmi.myapplication.DatabaseforProduct

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.Listners.CollectionItemClickListener
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.android.synthetic.main.products_item_layout.view.*

class MyProductViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    fun setData(myproducts: CatogoryProduct){
        view.apply {
            ivproductimagelist.setImageURI(Uri.parse(myproducts.myproductimage))
            tvproductItemName.text=myproducts.myproductname
            tvmrp.text=myproducts.mymrp
            tvpriceamount.text=myproducts.mysellingprice
            tvdiscountamount.text=myproducts.mydiscount
        }
    }
}