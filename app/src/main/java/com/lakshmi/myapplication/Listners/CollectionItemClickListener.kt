package com.lakshmi.myapplication.Listners

import com.lakshmi.myapplication.DatabaseForCollectionFragment.Collection
import com.lakshmi.myapplication.Model.ItemModel

interface CollectionItemClickListener {
    fun onItemClicked(itemModel:Collection, Position:Int)
}