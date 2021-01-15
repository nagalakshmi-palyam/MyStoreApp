package com.lakshmi.myapplication.Listners

import com.lakshmi.myapplication.RoomDatabse.Products

interface ProductItemClicklistner {
    fun onProductClicked(itemModel: Products, Position:Int)
}