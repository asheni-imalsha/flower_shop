package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Sign In button → Go to HomeActivity
        val btnSignIn = findViewById<MaterialButton>(R.id.btnSignIn)
        btnSignIn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        // "Don’t have an account? Sign Up"
        val tvGoToSignUp = findViewById<TextView>(R.id.tvGoToSignUp)
        tvGoToSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}