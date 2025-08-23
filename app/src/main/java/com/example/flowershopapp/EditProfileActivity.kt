package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class EditProfileActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Reusable nav
        setupTopNav()
        setupBottomNav()

        // Save button
        val btnSave = findViewById<MaterialButton>(R.id.btnSave)
        btnSave.setOnClickListener {
            // After saving → return to ProfileActivity
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish() // Close EditProfileActivity so back won't return here
        }
    }
}