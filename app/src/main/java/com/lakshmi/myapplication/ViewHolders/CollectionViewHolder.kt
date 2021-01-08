package com.lakshmi.myapplication.ViewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lakshmi.myapplication.Listners.ItemClickListner
import com.lakshmi.myapplication.Model.ItemModel
import com.lakshmi.myapplication.RoomDatabse.Products
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.storeproducts_item_layout.view.*

class CollectionViewHolder(private val view: View
): RecyclerView.ViewHolder(view) {
    fun setData(products: Products){
        var count1:Int=0;
        view.apply{
            tvItemname.text=products.choosecategory
            if(tvItemname.text=="Fashion"){
                count1++;
            }
            }
        }
    }
