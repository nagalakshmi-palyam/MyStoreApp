package com.lakshmi.myapplication.Activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomDatabse.ProductViewModel
import com.lakshmi.myapplication.RoomDatabse.ProductViewModelFactory
import kotlinx.android.synthetic.main.activity_add_product.*
import java.io.FileNotFoundException

class AddProduct : AppCompatActivity(), View.OnClickListener{
    private var discountpercen:Float=0.0f
    private var count=0
    private var Category=""
   // private var collection=""
    private var units=""
    private val REQUEST_GET_SINGLE_FILE = 1
    private lateinit var productViewModel:ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        productViewModel=ProductViewModelFactory(this).create(ProductViewModel::class.java)
        initviews()
        tvcollection.text=intent.getStringExtra("Category")
    }
    fun initviews() {
        var category:MutableList<String> = mutableListOf<String>()
//        category.add("Fashion")
//        category.add("Musical Instruments")
//        category.add("Furniture")
//        val spinner = findViewById<Spinner>(R.id.spinnercollection)
//        if (spinner != null) {
//            val adapter = ArrayAdapter(
//                this,
//                android.R.layout.simple_spinner_item, category
//            )
//            spinner.adapter = adapter
//
//            spinner.onItemSelectedListener = object :
//                AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(
//                    parent: AdapterView<*>,
//                    view: View, position: Int, id: Long
//                ) {
//                    collection = category[position]
//                    count++;
//                    Toast.makeText(
//                        this@AddProduct,
//                         collection+ " " +
//                                "" + category[position]+ count, Toast.LENGTH_SHORT
//                    ).show()
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>) {
//                    // write code to perform some action
//                }
//            }
        //}
            unitsSpinner()
            btnaddProduct.setOnClickListener(this)
            etAddimage.setOnClickListener(this)
            nextCollection.setOnClickListener(this)
    }
    fun unitsSpinner(){
        var unitslist:MutableList<String> = mutableListOf<String>()
        unitslist.add("kg")
        unitslist.add("gm")
        unitslist.add("dozen")
        unitslist.add("set")
        unitslist.add("ft")
        unitslist.add("Single")
        unitslist.add("pair")
        unitslist.add("month")
        unitslist.add("year")
        unitslist.add("ltr")
        val spinner = findViewById<Spinner>(R.id.unitSpinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, unitslist
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    units= unitslist[position]
//                    Toast.makeText(
//                        this@AddProduct,
//                         collection+ " " +
//                                "" + category[position], Toast.LENGTH_SHORT
//                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

    }

    override fun onClick(v: View?) {
      when(v?.id){
          R.id.btnaddProduct -> {

//              Toast.makeText(
//                  this@AddProduct,
//                  collection,Toast.LENGTH_SHORT
//              ).show()
              val intent = Intent(this@AddProduct, HomeActivity::class.java)
              startActivity(intent)

          }
          R.id.etAddimage->{
              if(isPermissionGranted()){
                  openGallery()
              } else{
                  requestStoragePermissions()
              }
              etAddimage.visibility=View.GONE
              productCard.visibility=View.VISIBLE
          }
          R.id.nextCollection->{
              if (isDataValid()) {
                  productViewModel.apply {
                      discountCalculate(etProductMrp.text.toString().toFloat(),etSellingPrize.text.toString().toFloat())
                      discountpercen=getDiscount()
                  }
                  //  discountpercen=(((etProductMrp.text.toString().toFloat()-etSellingPrize.text.toString().toFloat())/etProductMrp.text.toString().toFloat())*100)
                  productViewModel.insertDatatoDatabase(
                      productName = etProductName.text.toString(),
                      mrp = etProductMrp.text.toString(),
                      sellingPrice = etSellingPrize.text.toString(),
                      selectUnit = units,
                      addDesrciption = etDescription.text.toString(),
                      chooseCategory =Category,
                      productImage = etAddimage.text.toString(),
                      discount =  discountpercen.toString()
                  )
              }
              val intent = Intent(this@AddProduct, AddCollectionActivity::class.java)
              startActivity(intent)
          }
      }

    }
    fun isDataValid(): Boolean {
        if (etProductName.text.toString().isEmpty()) {
            etProductName.error = "Name cannot be empty"
            return false
        }

        if (etProductMrp.text.toString().isEmpty()) {
            etProductMrp.error = "Mrp cannot be empty"
            return false
        }
        if (etSellingPrize.text.toString().isEmpty()) {
            etSellingPrize.error = "Price cannot be empty"
            return false
        }
//        if (etUnits.text.toString().isEmpty()) {
//            etUnits.error = "Units cannot be empty"
//            return false
//        }
        if (etDescription.text.toString().isEmpty()) {
            etDescription.error = "Description cannot be empty"
            return false
        }
//        if (etCategory.text.toString().isEmpty()) {
//            etCategory.error = "Category cannot be empty"
//            return false
//        }
        return true
    }
    private fun openGallery() {
        val i = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(i, REQUEST_GET_SINGLE_FILE)
    }
    @SuppressLint("NewApi")
    private fun requestStoragePermissions() {
        requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_GET_SINGLE_FILE && resultCode == RESULT_OK && null != data) {
            val selectedImage = data.data
            try {
                val imageStream = contentResolver.openInputStream(selectedImage!!)
                getPathFromURI(selectedImage)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }
    private fun getPathFromURI(selectedImageUri: Uri): String? {
        val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(
            selectedImageUri,
            filePathColumn, null, null, null
        )
        cursor!!.moveToFirst()
        val columnIndex = cursor.getColumnIndex(filePathColumn[0])
        val picturePath = cursor.getString(columnIndex)
        cursor.close()
        Log.d("Lakshmi ", "Picture path $picturePath")
        Toast.makeText(this@AddProduct, "Picture Path$picturePath", Toast.LENGTH_SHORT).show()
        Toast.makeText(
            this@AddProduct,
            "Pictureselected Path$selectedImageUri",
            Toast.LENGTH_SHORT
        ).show()
        etAddimage.setText(picturePath)
        ivProductImage.setImageURI(Uri.parse(picturePath))
        return picturePath
    }
    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this@AddProduct,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

}