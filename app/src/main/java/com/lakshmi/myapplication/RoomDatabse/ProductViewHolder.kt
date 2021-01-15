package com.lakshmi.myapplication.RoomDatabse

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.Listners.CollectionItemClickListener
import com.lakshmi.myapplication.Listners.ProductItemClicklistner
import kotlinx.android.synthetic.main.products_item_layout.view.*

class ProductViewHolder(private val view: View,var productItemClicklistner: ProductItemClicklistner):RecyclerView.ViewHolder(view) {
    fun setData(products: Products,position:Int){
        view.apply {
            ivproductimagelist.setImageURI(Uri.parse(products.productimage))
            tvproductItemName.text=products.productname
            tvmrp.text=products.mrp
            tvpriceamount.text=products.sellingprice
            tvdiscountamount.text=products.discount
            tvdiscountamount.setOnClickListener {
                productItemClicklistner.onProductClicked(products,position)
            }
        }
    }
}