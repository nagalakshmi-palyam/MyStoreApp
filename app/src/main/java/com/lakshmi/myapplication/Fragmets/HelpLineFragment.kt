package com.lakshmi.myapplication.Fragmets

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.fragment_help_line.*

class HelpLineFragment : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_line, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initviews(view)
    }
    fun initviews(view:View){
        callonWhatsapp.setOnClickListener(this)
        callus.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.callus->{
               startcall()
            }
            R.id.callonWhatsapp->{

            }
        }
    }
    fun startcall() {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.setData(Uri.parse("tel:" + 9989831215))
        if (context?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.CALL_PHONE
                )
            } != PackageManager.PERMISSION_GRANTED) {
            return
        }
        startActivity(callIntent)
    }


}