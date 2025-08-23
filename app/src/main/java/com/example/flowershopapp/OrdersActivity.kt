package com.example.flowershopapp

import android.os.Bundle
import android.widget.TextView

class OrdersActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        setupTopNav()
        setupBottomNav()

        // ✅ Get data from CheckoutActivity
        val bouquetName = intent.getStringExtra("bouquetName") ?: "Blossom"
        val bouquetSize = intent.getStringExtra("bouquetSize") ?: "Deluxe"
        val wrapping = intent.getStringExtra("wrapping") ?: "None"
        val note = intent.getStringExtra("note") ?: "No note added"
        val quantity = intent.getIntExtra("quantity", 1)
        val price = intent.getIntExtra("bouquetPrice", 0) // ✅ now gets correct total
        val orderDate = intent.getStringExtra("orderDate") ?: "N/A"

        // ✅ Bind data to views
        findViewById<TextView>(R.id.tvOrderTitle).text =
            "Birthday Collection : $bouquetName - $bouquetSize"

        findViewById<TextView>(R.id.tvOrderNote).text =
            if (note.isNotEmpty()) note else "No note added"

        findViewById<TextView>(R.id.tvOrderWrapping).text =
            if (wrapping != "None") "$wrapping wrapping" else "No wrapping"

        findViewById<TextView>(R.id.tvOrderQuantity).text =
            "Quantity : $quantity"

        findViewById<TextView>(R.id.tvOrderPrice).text =
            "Rs. $price/-"

        findViewById<TextView>(R.id.tvOrderDate).text =
            "Order placed on : $orderDate"
    }
}