package com.lakshmi.myapplication.Fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.fragment_business_hours.*

class BusinessHours : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_business_hours, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initviews(view)
    }
    fun initviews(view:View){
        mbtnu.setOnClickListener(this)
        mbtns.setOnClickListener(this)
        tbtnu.setOnClickListener(this)
        tbtns.setOnClickListener(this)
        wbtnu.setOnClickListener(this)
        wbtns.setOnClickListener(this)
        thbtnu.setOnClickListener(this)
        thbtns.setOnClickListener(this)
        fbtnu.setOnClickListener(this)
        fbtns.setOnClickListener(this)
        satbtnu.setOnClickListener(this)
        satbtns.setOnClickListener(this)
        sunbtnu.setOnClickListener(this)
        sunbtns.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mbtns->{
                mbtns.visibility=View.GONE
                mbtnu.visibility=View.VISIBLE
                tvchangem.text="Closed"
            }
            R.id.mbtnu->{
                mbtns.visibility=View.VISIBLE
                mbtnu.visibility=View.GONE
                tvchangem.text="change"
            }
            R.id.tbtns->{
                tbtns.visibility=View.GONE
                tbtnu.visibility=View.VISIBLE
                tvchanget.text="Closed"
            }
            R.id.tbtnu->{
                tbtns.visibility=View.VISIBLE
                tbtnu.visibility=View.GONE
                tvchanget.text="change"
            }
            R.id.wbtns->{
                wbtns.visibility=View.GONE
                wbtnu.visibility=View.VISIBLE
                tvchangew.text="Closed"
            }
            R.id.wbtnu->{
                wbtns.visibility=View.VISIBLE
                wbtnu.visibility=View.GONE
                tvchangew.text="change"
            }
            R.id.thbtns->{
                thbtns.visibility=View.GONE
                thbtnu.visibility=View.VISIBLE
                tvchangeth.text="Closed"
            }
            R.id.thbtnu->{
                thbtns.visibility=View.VISIBLE
                thbtnu.visibility=View.GONE
                tvchangeth.text="change"
            }
            R.id.fbtns->{
                fbtns.visibility=View.GONE
                fbtnu.visibility=View.VISIBLE
                tvchangef.text="Closed"
            }
            R.id.fbtnu->{
                fbtns.visibility=View.VISIBLE
                fbtnu.visibility=View.GONE
                tvchangef.text="change"
            }
            R.id.satbtns->{
                satbtns.visibility=View.GONE
                satbtnu.visibility=View.VISIBLE
                tvchangesat.text="Closed"
            }
            R.id.satbtnu->{
                satbtns.visibility=View.VISIBLE
                satbtnu.visibility=View.GONE
                tvchangesat.text="change"
            }
            R.id.sunbtns->{
                sunbtns.visibility=View.GONE
                sunbtnu.visibility=View.VISIBLE
                tvchangesun.text="Closed"
            }
            R.id.sunbtnu->{
                sunbtns.visibility=View.VISIBLE
                sunbtnu.visibility=View.GONE
                tvchangesun.text="change"
            }
        }
    }


}