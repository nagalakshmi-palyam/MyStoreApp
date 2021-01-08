package com.lakshmi.myapplication.Activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionViewModel
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionViewModelFactory
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomDatabse.ProductViewModel
import com.lakshmi.myapplication.RoomDatabse.ProductViewModelFactory
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_collection_name.*
import kotlinx.android.synthetic.main.activity_collection_name.btnaddCollection
import kotlinx.android.synthetic.main.activity_next_collection.*
import java.io.FileNotFoundException

class CollectionName : AppCompatActivity(), View.OnClickListener {
    private var picturepath=""
    private lateinit var collectinviewModel: CollectionViewModel
    private val REQUEST_GET_SINGLE_FILE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection_name)
        collectinviewModel= CollectionViewModelFactory(this).create(CollectionViewModel::class.java)
        initviews()
    }
    fun initviews(){
        backAllcollection.setOnClickListener(this)
        plustoaddimage.setOnClickListener(this)
        etcollectionname.setOnClickListener(this)
        btnaddCollection.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backAllcollection->{
                val intent = Intent(this@CollectionName,AddCollectionActivity::class.java)
                startActivity(intent)
            }
            R.id.plustoaddimage->{
                if(isPermissionGranted()){
                    openGallery()
                } else{
                    requestStoragePermissions()
                }
            }
            R.id.etcollectionname->{

            }
            R.id.btnaddCollection->{
                if(isDataValid()){
                    collectinviewModel.insertDatatoDatabase(categoryName = etcollectionname.text.toString(),imageUri = picturepath,"1"
                    )
                }
                val intent = Intent(this@CollectionName,AddCollectionActivity::class.java)
                startActivity(intent)
            }
        }
    }
    fun isDataValid(): Boolean {
        if (etcollectionname.text.toString().isEmpty()) {
            etcollectionname.error = "Name cannot be empty"
            return false
        }
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
        Toast.makeText(this@CollectionName, "Picture Path$picturePath", Toast.LENGTH_SHORT).show()
        Toast.makeText(
            this@CollectionName,
            "Pictureselected Path$selectedImageUri",
            Toast.LENGTH_SHORT
        ).show()
        picturepath=picturePath
        //etAddimage.setText(picturePath)
        ivcollectionimage.setImageURI(Uri.parse(picturePath))
        return picturePath
    }
    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this@CollectionName,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }
}