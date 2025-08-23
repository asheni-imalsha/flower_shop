package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Create Account button → Go to HomeActivity
        val btnSignUp = findViewById<MaterialButton>(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        // "Already have an account? Sign In"
        val tvGoToSignIn = findViewById<TextView>(R.id.tvGoToSignIn)
        tvGoToSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}