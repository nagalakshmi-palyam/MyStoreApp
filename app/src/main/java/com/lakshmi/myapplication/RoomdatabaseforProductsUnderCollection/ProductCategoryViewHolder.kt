package com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.android.synthetic.main.productcategory_items.view.*
import kotlinx.android.synthetic.main.products_item_layout.view.*
import kotlinx.android.synthetic.main.products_item_layout.view.ivproductimagelist
import kotlinx.android.synthetic.main.products_item_layout.view.tvproductItemName

class ProductCategoryViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    fun setData(products: Productcategory){
        view.apply {
            ivproductimagelist2.setImageURI(Uri.parse(products.categorproductimage))
            tvproductItemName2.text=products.categorproductname
            tvmrp2.text=products.categormrp
            tvpriceamount2.text=products.categorsellingprice
            tvdiscountamount2.text=products.categordiscount
        }
    }
}