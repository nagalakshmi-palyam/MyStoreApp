//package com.lakshmi.myapplication.DatabaseForCollectionFragment;
//
//import androidx.room.Embedded;
//import androidx.room.Relation;
//
//import java.io.Serializable;
//
//public class CollectionProduct implements Serializable {
//    @Embedded
//    private MyCollection collectionjava;
//
//    @Relation(
//            parentColumn = "categoryid",
//            entityColumn = "categoryproductid"
//    )
//    private ProductsunderCategory productscategory;
//
//    public MyCollection getCollectionjava() {
//        return collectionjava;
//    }
//
//    public ProductsunderCategory getProductscategory() {
//        return productscategory;
//    }
//
//    public void setCollectionjava(MyCollection collectionjava) {
//        this.collectionjava = collectionjava;
//    }
//
//    public void setProductscategory(ProductsunderCategory productscategory) {
//        this.productscategory = productscategory;
//    }
//}
