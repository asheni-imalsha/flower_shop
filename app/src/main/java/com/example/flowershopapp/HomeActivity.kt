package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class HomeActivity : BaseActivity() {   // extend BaseActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Enable reusable navigation
        setupTopNav()
        setupBottomNav()

        // ─── Search button navigation (only keep search here) ───
        val icoSearch = findViewById<TextView>(R.id.icoSearch)
        icoSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }
}