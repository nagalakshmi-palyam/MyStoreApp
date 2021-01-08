package com.lakshmi.myapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_business.*

class BusinessActivity : AppCompatActivity(), View.OnClickListener {
    private var businessName:String=""
    private var StoreName:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business)
        initViews()
    }
    fun initViews(){
        etbusinessName.setOnClickListener(this)
        etstoreName.setOnClickListener(this)
        btnSave.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.etbusinessName->{
                tvbusinessSmall.visibility=View.VISIBLE
                tvBusinessbig.visibility=View.GONE

            }
            R.id.etstoreName->{
                tvStoreSmall.visibility=View.VISIBLE
                tvSoreBig.visibility=View.GONE
            }
            R.id.btnSave->{
                if(isDataValid()){
                    businessName=etbusinessName.text.toString()
                    StoreName=etstoreName.text.toString()
                }
                val intent = Intent(this@BusinessActivity, TypesofProductsActivity::class.java)
                intent.putExtra("business",businessName)
                intent.putExtra("store",StoreName)
                startActivity(intent)
            }
        }
    }
    fun isDataValid(): Boolean {
        if (etbusinessName.text.toString().isEmpty()) {
            etbusinessName.error = "Name cannot be empty"
            return false
        }

        if (etstoreName.text.toString().isEmpty()) {
            etstoreName.error = "Mrp cannot be empty"
            return false
        }
        return true
    }
}