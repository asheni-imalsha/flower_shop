package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import android.widget.*

class ProductActivity : BaseActivity() {

    private var quantity = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        // Reuse nav bars
        setupTopNav()
        setupBottomNav()

        val tvQuantity = findViewById<TextView>(R.id.tvQuantity)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnAddToCart = findViewById<Button>(R.id.btnAddToCart)

        val radioGroupBouquet = findViewById<RadioGroup>(R.id.radioGroupBouquet)
        val radioGroupWrapping = findViewById<RadioGroup>(R.id.radioGroupWrapping)
        val etNote = findViewById<EditText>(R.id.etNote)

        // ➖ Decrease Quantity
        btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                tvQuantity.text = quantity.toString()
            }
        }

        // ➕ Increase Quantity
        btnPlus.setOnClickListener {
            quantity++
            tvQuantity.text = quantity.toString()
        }

        // 🛒 Add to Cart
        btnAddToCart.setOnClickListener {
            // Wrapping option
            val selectedWrapId = radioGroupWrapping.checkedRadioButtonId
            val wrapping = if (selectedWrapId != -1) {
                findViewById<RadioButton>(selectedWrapId).text.toString()
            } else {
                "None"
            }

            // Bouquet size selection
            val selectedSizeId = radioGroupBouquet.checkedRadioButtonId
            var bouquetSize = "Not selected"
            var bouquetPrice = 0

            when (selectedSizeId) {
                R.id.radioGrand -> {
                    bouquetSize = "Grand"
                    bouquetPrice = 7500
                }
                R.id.radioDeluxe -> {
                    bouquetSize = "Deluxe"
                    bouquetPrice = 4500
                }
                R.id.radioOriginal -> {
                    bouquetSize = "Original"
                    bouquetPrice = 3500
                }
            }

            if (bouquetSize == "Not selected") {
                Toast.makeText(this, "Please select a bouquet size", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Optional note
            val note = etNote.text.toString()

            val bouquetName = "Blossom"

            // 🔹 Toast confirmation
            Toast.makeText(
                this,
                "Added $quantity $bouquetName bouquet(s)\nSize: $bouquetSize\nWrapping: $wrapping",
                Toast.LENGTH_SHORT
            ).show()

            // 🔹 Navigate to CartActivity with data
            val intent = Intent(this, CartActivity::class.java).apply {
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