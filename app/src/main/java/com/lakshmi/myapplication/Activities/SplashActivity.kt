package com.lakshmi.myapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.lakshmi.myapplication.R

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH = 4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, BusinessActivity::class.java)
            this@SplashActivity.startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}