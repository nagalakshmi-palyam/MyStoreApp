package com.lakshmi.myapplication.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.lakshmi.myapplication.Adapters.FragmentAdapter
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity(), OnTabSelectedListener {
    private lateinit var fregmentAdapter:FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        btnnextactivity.setOnClickListener{
            val intent= Intent(this@ViewPagerActivity, BusinessActivity::class.java)
            startActivity(intent)
        }
        setViewPagerAdapter()

    }
    private fun setViewPagerAdapter() {
        fregmentAdapter = FragmentAdapter(this)
            myviewpager.adapter=fregmentAdapter
        //tabLayout.setupWithViewPager(myviewpager)
        TabLayoutMediator(
            tabLayout, myviewpager
        ) { tab, position -> Log.d("Lakshmi", "Configurable tab called") }.attach()


    }


    override fun onTabReselected(p0: TabLayout.Tab?) {

    }

    override fun onTabSelected(p0: TabLayout.Tab?) {

    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {

    }

}