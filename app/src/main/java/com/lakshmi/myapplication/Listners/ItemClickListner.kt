package com.lakshmi.myapplication.Listners

import com.lakshmi.myapplication.Model.ItemModel

interface ItemClickListner {
    fun onItemClicked(itemModel: ItemModel,Position:Int)
}