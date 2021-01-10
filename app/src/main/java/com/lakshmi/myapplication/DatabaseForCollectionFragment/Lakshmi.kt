//package com.lakshmi.myapplication.DatabaseForCollectionFragment
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.Ignore
//import androidx.room.PrimaryKey
//import java.util.*
//
//@Entity(tableName = "Category")
//data class Lakshmi (
//    @PrimaryKey
//    @ColumnInfo(name = "categoryid")
//    private val categoryid: String ,
//
//    @ColumnInfo(name = "categoryname")
//    private val categoryname: String,
//
//    @ColumnInfo(name = "categoryimage")
//    private val categoryimage: String,
//
//    @ColumnInfo(name = "productcountnumbers")
//    private val productcountnumbers: String,
//)
//{
//    @Ignore
//    fun MyCollection(categoryname: String, categoryimage: String, productcountnumbers: String) {
//        this(UUID.randomUUID().toString(), categoryname, categoryimage, productcountnumbers)
//    }
//
//    private operator fun invoke(toString: String, categoryname: String, categoryimage: String, productcountnumbers: String) {
//
//    }
//}