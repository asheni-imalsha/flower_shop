package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class ProfileActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Reusable navigation
        setupTopNav()
        setupBottomNav()

        // Buttons
        val btnCart = findViewById<MaterialButton>(R.id.btnCart)
        val btnDiscounts = findViewById<MaterialButton>(R.id.btnDiscounts)
        val btnEditProfile = findViewById<MaterialButton>(R.id.btnEditProfile)
        val btnOrders = findViewById<MaterialButton>(R.id.btnOrders)  // ✅ Orders button

        btnCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        btnDiscounts.setOnClickListener {
            startActivity(Intent(this, DealsActivity::class.java))
        }

        btnEditProfile.setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
        }

        // ✅ Open OrdersActivity
        btnOrders.setOnClickListener {
            startActivity(Intent(this, OrdersActivity::class.java))
        }
    }
}