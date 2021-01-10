package com.lakshmi.myapplication.Fragmets

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.lakshmi.myapplication.Activities.HomeActivity
import com.lakshmi.myapplication.Activities.VideoActivity
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.fragment_account.*
import java.io.FileNotFoundException

class AccountFragment : Fragment(), View.OnClickListener{
    private val REQUEST_GET_SINGLE_FILE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }
    fun initViews(view:View){
     cardvideo.setOnClickListener(this)
        cardhelp.setOnClickListener(this)
        cardsecurity.setOnClickListener(this)
        cardshare.setOnClickListener(this)
        ivprofileimage.setOnClickListener(this)
        cardpromote.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
       when(v?.id){
           R.id.cardvideo->{
               val video = VideoFragment()
               activity?.let {
                   it.supportFragmentManager.beginTransaction().replace(R.id.fragment_Container,video).addToBackStack("Video").commit()
               }
           }
           R.id.cardhelp->{
               val helpline = HelpLineFragment()
               activity?.let {
                   it.supportFragmentManager.beginTransaction().replace(R.id.fragment_Container,helpline).addToBackStack("Helpline").commit()
               }
           }
           R.id.cardsecurity->{
               val privacy = PrivacyFragment()
               activity?.let {
                   it.supportFragmentManager.beginTransaction().replace(R.id.fragment_Container,privacy).addToBackStack("Privacy").commit()
               }
           }
           R.id.cardshare->{
               val intent=Intent(Intent.ACTION_SEND)
               intent.setType("text/plain")
               var sharebody="Download the App now:https://play.google.com/store/apps/details?id=com.khatabook.dukaan"
               var sharesub="MyDukan"
               intent.putExtra(Intent.EXTRA_SUBJECT,sharesub)
               intent.putExtra(Intent.EXTRA_SUBJECT,sharebody,)
               startActivity(Intent.createChooser(intent,"Share Using"))
           }
           R.id.ivprofileimage->{

           }
           R.id.cardpromote->{
               val promotion = PromotionFragment()
               activity?.let {
                   it.supportFragmentManager.beginTransaction().replace(R.id.fragment_Container,promotion).addToBackStack("Promotion").commit()
               }
           }
       }
    }



}