package com.example.fajar_time

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi View untuk animasi
        val ivLogo = findViewById<ImageView>(R.id.ivLogo)
        val tvAppName = findViewById<TextView>(R.id.tvAppName)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)

        // Animasi fade in
        val fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in).apply {
            duration = 1500
        }
        
        ivLogo.startAnimation(fadeIn)
        tvAppName.startAnimation(fadeIn)
        tvDescription.startAnimation(fadeIn)

        // Ambil SharedPreferences untuk mengecek status login
        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        // Jalankan coroutine dengan delay 3 detik
        lifecycleScope.launch {
            delay(3000)
            
            // Tentukan target Activity berdasarkan status login
            // Diarahkan ke BaseActivity sesuai instruksi SS
            val targetActivity = if (isLogin) {
                BaseActivity::class.java
            } else {
                AuthActivity::class.java
            }
            
            val intent = Intent(this@SplashScreenActivity, targetActivity)
            startActivity(intent)
            finish()
        }
    }
}
