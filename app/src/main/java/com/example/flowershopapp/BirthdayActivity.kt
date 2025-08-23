package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.card.MaterialCardView

class BirthdayActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday)

        // Reuse top and bottom navigation
        setupTopNav()
        setupBottomNav()

        // 🌸 Blossom bouquet click → open ProductActivity
        val cardBlossom = findViewById<MaterialCardView>(R.id.cardBlossom)
        cardBlossom?.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra("title", "Blossom")
            intent.putExtra("image", R.drawable.blossom)
            startActivity(intent)
        }
    }
}