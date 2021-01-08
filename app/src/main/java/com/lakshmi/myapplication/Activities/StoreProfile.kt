package com.lakshmi.myapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.activity_store_profile.*

class StoreProfile : AppCompatActivity(), View.OnClickListener {
    private var mybusinessname:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_profile)
        mybusinessname=intent.getStringExtra("itemname").toString()
        tvproduct1.text=intent.getStringExtra("itemname")
        tvmystorename.text=intent.getStringExtra("businesname")
        initviews()
    }
    fun initviews(){
    btnproductaddActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnproductaddActivity->{
                val intent = Intent(this@StoreProfile , AddProduct::class.java)
                intent.putExtra("businessname",mybusinessname)
               startActivity(intent)
            }
        }
    }
}