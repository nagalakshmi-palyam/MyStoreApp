package com.lakshmi.myapplication.RoomdatabaseforProductsUnderCollection

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "mycategory")
data class Productcategory(
    @PrimaryKey(autoGenerate = true)
    var productcategoryId: Int = 0,
    @ColumnInfo(name = "categoryproductname")
    val categorproductname: String,
    @ColumnInfo(name = "categormrp")
    val categormrp: String,
    @ColumnInfo(name = "categorsellingprice")
    val categorsellingprice:String,
    @ColumnInfo(name="categorproductimage")
    val categorproductimage:String,
    @ColumnInfo(name="categordiscount")
    val categordiscount:String,
    @ColumnInfo(name="collectionName")
    val collectionName:String

)