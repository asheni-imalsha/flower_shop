package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class SearchActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // enable shared bottom nav + top nav
        setupBottomNav()
        setupTopNav()

        // back button (finish this screen → return Home)
        val icoBack = findViewById<TextView>(R.id.icoBack)
        icoBack.setOnClickListener { finish() }

        // ─── Birthday category click → open BirthdayActivity ───
        val catBirthday = findViewById<LinearLayout>(R.id.catBirthday)
        catBirthday.setOnClickListener {
            startActivity(Intent(this, BirthdayActivity::class.java))
        }
    }
}