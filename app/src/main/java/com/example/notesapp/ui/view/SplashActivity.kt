package com.example.notesapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    private fun initial() {
        Handler().postDelayed({
            val intent = Intent(
                this@SplashActivity,
                HomeActivity::class.java
            )
            startActivity(intent)
            finish()
        }, 1500)
    }
}