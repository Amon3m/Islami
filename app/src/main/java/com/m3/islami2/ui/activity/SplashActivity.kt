package com.m3.islami2.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.m3.islami2.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            goToMain();
        },2000)
    }

    private fun goToMain() {
        intent= Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}