package com.lakshmi.myapplication.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lakshmi.myapplication.Fragmets.*
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var selectedFragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initviews()
        launchHomefragment()
    }
    fun initviews(){
        bottomNavigationView= BottomNavigationView(this)
        bottom_navigation.setOnNavigationItemSelectedListener(navigationItemSelectedlistener)

    }
    private val navigationItemSelectedlistener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> selectedFragment = HomeFragment()
                R.id.nav_orders->selectedFragment=OrdersFragment()
                R.id.nav_Products->selectedFragment=Productsragment()
                R.id.nav_category->selectedFragment=CategoriesFragment()
                R.id.nav_acount->selectedFragment=AccountFragment()
            }
            if (selectedFragment != null) {
                val fragmentmanger = supportFragmentManager
                fragmentmanger.beginTransaction().replace(
                    R.id.fragment_Container,
                    selectedFragment!!
                ).commit()
            }
            true
        }
    fun launchHomefragment(){
        val fragmentmanger = supportFragmentManager
        fragmentmanger.beginTransaction().add(R.id.fragment_Container, HomeFragment()).
        addToBackStack("Homefragment").commit()
    }
}