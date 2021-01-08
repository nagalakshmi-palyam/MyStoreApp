package com.lakshmi.myapplication.RoomDatabse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class Products (
    @PrimaryKey(autoGenerate = true)
    var productId: Int = 0,

    @ColumnInfo(name = "productname")
    val productname: String,

    @ColumnInfo(name = "mrp")
    val mrp: String,
    @ColumnInfo(name = "sellingprice")
    val sellingprice:String,
    @ColumnInfo(name ="selectunit")
    val selectunit:String,
    @ColumnInfo(name="addproductdescription")
    val addproductdescription:String,
    @ColumnInfo(name = "choosecategory")
    val choosecategory:String,
    @ColumnInfo(name="productimage")
    val productimage:String,
    @ColumnInfo(name="discount")
    val discount:String
)