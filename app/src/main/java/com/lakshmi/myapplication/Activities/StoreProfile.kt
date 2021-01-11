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
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.StoreNameDatabase.StoreViewModel
import com.lakshmi.myapplication.StoreNameDatabase.StoreViewModelFactory
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_store_profile.*
import java.io.FileNotFoundException

class StoreProfile : AppCompatActivity(), View.OnClickListener {
    private lateinit var storeViewModel: StoreViewModel
    private val REQUEST_GET_SINGLE_FILE = 1
    private var myprofilepic=""
    private var mybusinesstype:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_profile)
        mybusinesstype=intent.getStringExtra("itemname").toString()
        tvproduct1.text=intent.getStringExtra("itemname")
        tvmystorename.text=intent.getStringExtra("businesname")
        initviews()
    }
    fun initviews(){
    btnproductaddActivity.setOnClickListener(this)
        storeViewModel=StoreViewModelFactory(this).create(StoreViewModel::class.java)
        ivprofileimage.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnproductaddActivity->{
                storeViewModel.inserprofiletoDatabase(stoprofileImage = myprofilepic,businesstype = mybusinesstype)

                val intent = Intent(this@StoreProfile , AddProduct::class.java)
                intent.putExtra("businessname",mybusinesstype)
               startActivity(intent)
            }
            R.id.ivprofileimage->{
                if(isPermissionGranted()){
                    openGallery()
                } else{
                    requestStoragePermissions()
                }
            }
        }
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
        Toast.makeText(this@StoreProfile, "Picture Path$picturePath", Toast.LENGTH_SHORT).show()
        Toast.makeText(
            this@StoreProfile,
            "Pictureselected Path$selectedImageUri",
            Toast.LENGTH_SHORT
        ).show()
        myprofilepic=picturePath
        ivprofileimage.setImageURI(Uri.parse(picturePath))
        return picturePath
    }
    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this@StoreProfile,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }
}