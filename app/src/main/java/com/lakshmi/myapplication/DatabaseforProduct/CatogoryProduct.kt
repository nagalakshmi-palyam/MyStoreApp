package com.lakshmi.myapplication.DatabaseforProduct

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "myProduct")
data class CatogoryProduct (
    @PrimaryKey(autoGenerate = true)
    var productId: Int = 0,

    @ColumnInfo(name = "myproductname")
    val myproductname: String,

    @ColumnInfo(name = "mymrp")
    val mymrp: String,
    @ColumnInfo(name = "mysellingprice")
    val mysellingprice:String,
    @ColumnInfo(name ="selectunit")
    val myselectunit:String,
    @ColumnInfo(name="myaddproductdescription")
    val myaddproductdescription:String,
    @ColumnInfo(name = "mychoosecategory")
    val mychoosecategory:String,
    @ColumnInfo(name="myproductimage")
    val myproductimage:String,
    @ColumnInfo(name="mydiscount")
    val mydiscount:String
)