package com.dro.enterperform.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dro.enterperform.eventsScreen.ui.MainActivity
import com.dro.enterperform.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            handleNavigation()
        }, 2000)

    }

    fun handleNavigation() {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
    }

}