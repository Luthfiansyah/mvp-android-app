package com.jalanesia.mytrip

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 2500 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        val bg: LinearLayout = findViewById(android.R.id.background) as LinearLayout
//        val aniFadeBg = AnimationUtils.loadAnimation(
//            applicationContext,
//            android.R.anim.fade_in
//        )
//        bg.startAnimation(aniFadeBg)

        val img: TextView = findViewById(R.id.tagLine) as TextView
        val aniFade: Animation =
            AnimationUtils.loadAnimation(applicationContext, android.R.anim.fade_in)
        img.startAnimation(aniFade)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,MainActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}