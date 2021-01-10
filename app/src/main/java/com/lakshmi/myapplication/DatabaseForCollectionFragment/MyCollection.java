//package com.lakshmi.myapplication.DatabaseForCollectionFragment;
//
//import androidx.annotation.NonNull;
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.Ignore;
//import androidx.room.PrimaryKey;
//
//import java.util.UUID;
//
//@Entity(tableName = "Category")
//public class MyCollection {
//    @NonNull
//    @PrimaryKey
//    @ColumnInfo(name = "categoryid")
//    private String categoryid;
//    @ColumnInfo(name = "categoryname")
//    private String categoryname;
//    @ColumnInfo(name = "categoryimage")
//    private String categoryimage;
//    @ColumnInfo(name = "productcountnumbers")
//    private String productcountnumbers;
//
//    @Ignore
//    public MyCollection(String categoryname, String categoryimage, String productcountnumbers) {
//        this(UUID.randomUUID().toString(),categoryname,categoryimage,productcountnumbers);
//    }
//
//    public void setCategoryid(@NonNull String categoryid) {
//        this.categoryid = categoryid;
//    }
//
//    public void setCategoryname(String categoryname) {
//        this.categoryname = categoryname;
//    }
//
//    public void setCategoryimage(String categoryimage) {
//        this.categoryimage = categoryimage;
//    }

//
//    public void setProductcountnumbers(String productcountnumbers) {
//        this.productcountnumbers = productcountnumbers;
//    }
//
//    @NonNull
//    public String getCategoryid() {
//        return categoryid;
//    }
//
//    public String getCategoryname() {
//        return categoryname;
//    }
//
//    public String getCategoryimage() {
//        return categoryimage;
//    }
//
//    public String getProductcountnumbers() {
//        return productcountnumbers;
//    }
//
//    public MyCollection(@NonNull String categoryid, String categoryname, String categoryimage, String productcountnumbers) {
//        this.categoryid = categoryid;
//        this.categoryname = categoryname;
//        this.categoryimage = categoryimage;
//        this.productcountnumbers = productcountnumbers;
//    }
//
//    @Override
//    public String toString() {
//        return "Collectionjava{" +
//                "categoryid='" + categoryid + '\'' +
//                ", categoryname='" + categoryname + '\'' +
//                ", categoryimage='" + categoryimage + '\'' +
//                ", productcountnumbers='" + productcountnumbers + '\'' +
//                '}';
//    }
//}
