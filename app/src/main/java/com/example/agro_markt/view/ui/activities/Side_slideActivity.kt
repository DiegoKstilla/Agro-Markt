package com.example.agro_markt.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.agro_markt.R
import com.example.agro_markt.databinding.ActivitySideSlideBinding

// Suppress permite el FLAG_FULLSCREEN porque este ya se encuentra deprecado
@Suppress("DEPRECATION")
class side_slideActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySideSlideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySideSlideBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//      HACE QUE SE VEA A PANTALLA COMPLETA EL SPLASHSCREEN
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val animation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        binding.ivSideSlide.startAnimation(animation)
        val intent = Intent(this, LoginActivity::class.java)

        animation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

    }
}