package com.example.fajar_time.Home.Pertemuan_4

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fajar_time.Home.Pertemuan_5.FifthActivity
import com.example.fajar_time.Home.Pertemuan_3.LoginActivity
import com.example.fajar_time.R
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        
        // Menggunakan main_layout dari activity_home.xml
        val rootView = findViewById<CoordinatorLayout>(R.id.main_layout)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvTitle = "Dashboard Utama" // Judul halaman utama
        val tvDesc = "Pilih menu pembelajaran Anda hari ini" // Deskripsi halaman utama

        val cardRumus = findViewById<CardView>(R.id.cardRumus)
        val cardCustom1 = findViewById<CardView>(R.id.cardCustom1)
        val cardCustom2 = findViewById<CardView>(R.id.cardCustom2)
        val cardLogout = findViewById<CardView>(R.id.cardLogout)

        cardRumus.setOnClickListener {
            // Navigasi ke FifthActivity agar Anda bisa mengambil screenshot bukti
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }

        cardCustom1.setOnClickListener {
            navigateToDetail("UI/UX Design", tvTitle, tvDesc)
        }

        cardCustom2.setOnClickListener {
            navigateToDetail("Android Development", tvTitle, tvDesc)
        }

        cardLogout.setOnClickListener {
            showLogoutDialog()
        }
    }

    private fun navigateToDetail(pageTitle: String, parentTitle: String, parentDesc: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("PAGE_TITLE", pageTitle)
        intent.putExtra("PARENT_TITLE", parentTitle)
        intent.putExtra("PARENT_DESC", parentDesc)
        startActivity(intent)
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Apakah Anda yakin ingin logout?")
            .setPositiveButton("Ya") { _, _ ->
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("Tidak") { _, _ ->
                Snackbar.make(findViewById(R.id.main_layout), "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
            }
            .show()
    }
}