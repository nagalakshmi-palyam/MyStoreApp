//package com.lakshmi.myapplication.DatabaseForCollectionFragment;
//
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.ForeignKey;
//import androidx.room.PrimaryKey;
//
//import static androidx.room.ForeignKey.CASCADE;
//
//@Entity(tableName = "myproducts",
//        foreignKeys = @ForeignKey(
//                entity = MyCollection.class,
//                parentColumns = "categoryid",
//                childColumns = "categoryproductid",
//                onDelete = CASCADE
//        ))
//public class ProductsunderCategory {
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "myproductid")
//    private int myproductid;
//    @ColumnInfo(name = "categoryproductid")
//    private String GuygirlId;
//
//    @ColumnInfo(name = "myproductname")
//    private String myproductname;
//    @ColumnInfo(name = "myproductimage")
//    private int myproductimage;
//    @ColumnInfo(name = "mymrp")
//    private int mymrp;
//    @ColumnInfo(name = "mypsellingprice")
//    private int mypsellingprice;
//    @ColumnInfo(name = "mydiscount")
//    private int mydiscount;
//
//    public ProductsunderCategory() {
//
//    }
//
//    public int getMyproductid() {
//        return myproductid;
//    }
//
//    public String getGuygirlId() {
//        return GuygirlId;
//    }
//
//    public String getMyproductname() {
//        return myproductname;
//    }
//
//    public int getMyproductimage() {
//        return myproductimage;
//    }
//
//    public int getMymrp() {
//        return mymrp;
//    }
//
//    public int getMypsellingprice() {
//        return mypsellingprice;
//    }
//
//    public int getMydiscount() {
//        return mydiscount;
//    }
//
//    public void setMyproductid(int myproductid) {
//        this.myproductid = myproductid;
//    }
//
//    public void setGuygirlId(String guygirlId) {
//        GuygirlId = guygirlId;
//    }
//
//    public void setMyproductname(String myproductname) {
//        this.myproductname = myproductname;
//    }
//
//    public void setMyproductimage(int myproductimage) {
//        this.myproductimage = myproductimage;
//    }
//
//    public void setMymrp(int mymrp) {
//        this.mymrp = mymrp;
//    }
//
//    public void setMypsellingprice(int mypsellingprice) {
//        this.mypsellingprice = mypsellingprice;
//    }
//
//    public void setMydiscount(int mydiscount) {
//        this.mydiscount = mydiscount;
//    }
//
//    @Override
//    public String toString() {
//        return "ProductsunderCategory{" +
//                "myproductid=" + myproductid +
//                ", GuygirlId='" + GuygirlId + '\'' +
//                ", myproductname='" + myproductname + '\'' +
//                ", myproductimage=" + myproductimage +
//                ", mymrp=" + mymrp +
//                ", mypsellingprice=" + mypsellingprice +
//                ", mydiscount=" + mydiscount +
//                '}';
//    }
//}
