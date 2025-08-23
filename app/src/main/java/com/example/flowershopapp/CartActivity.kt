package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Reuse nav bars
        setupTopNav()
        setupBottomNav()

        // Get data from intent
        val bouquetName = intent.getStringExtra("bouquetName") ?: "Blossom"
        val bouquetSize = intent.getStringExtra("bouquetSize") ?: "Deluxe"
        val bouquetPrice = intent.getIntExtra("bouquetPrice", 4500)
        val wrapping = intent.getStringExtra("wrapping") ?: "None"
        val note = intent.getStringExtra("note") ?: ""
        val quantity = intent.getIntExtra("quantity", 1)

        // Calculate total
        val noteCharge = if (note.isNotEmpty()) 150 else 0
        val wrappingCharge = if (wrapping != "None") 300 else 0
        val total = (bouquetPrice * quantity) + noteCharge + wrappingCharge

        // Bind to views
        findViewById<TextView>(R.id.tvCartBouquet).text =
            "Birthday Collection : $bouquetName - $bouquetSize"
        findViewById<TextView>(R.id.tvCartPrice).text =
            "Rs. $bouquetPrice/- x $quantity"
        findViewById<TextView>(R.id.tvCartNote).text =
            if (note.isNotEmpty()) "Note: $note\nExtra Rs. $noteCharge/- added for the note."
            else "No note added"
        findViewById<TextView>(R.id.tvCartWrapping).text =
            "Wrapping Option: $wrapping\nExtra Rs. $wrappingCharge/- added for wrapping."
        findViewById<TextView>(R.id.tvCartTotal).text =
            "Total : Rs. $total/-"

        // ✅ Proceed to Checkout
        findViewById<Button>(R.id.btnCheckout).setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java).apply {
                putExtra("bouquetName", bouquetName)
                putExtra("bouquetSize", bouquetSize)
                putExtra("bouquetPrice", bouquetPrice)
                putExtra("wrapping", wrapping)
                putExtra("note", note)
                putExtra("quantity", quantity)
            }
            startActivity(intent)
        }
    }
}