package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class DealsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deals)

        // Setup reusable navigations
        setupTopNav()
        setupBottomNav() // 🔹 Add this line

        // ─── Shop Here button → SearchActivity ───
        val btnShopHere = findViewById<MaterialButton>(R.id.btnShopHere)
        btnShopHere.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }
}