package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btnGetStarted = findViewById<MaterialButton>(R.id.btnGetStarted)
        btnGetStarted.setOnClickListener {
            val intent = Intent(this, DiscoverActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}