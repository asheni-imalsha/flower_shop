package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.util.*

class CheckoutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        setupTopNav()
        setupBottomNav()

        // Get data passed from CartActivity
        val bouquetName = intent.getStringExtra("bouquetName") ?: "Blossom"
        val bouquetSize = intent.getStringExtra("bouquetSize") ?: "Deluxe"
        val bouquetPrice = intent.getIntExtra("bouquetPrice", 4500)
        val wrapping = intent.getStringExtra("wrapping") ?: "None"
        val note = intent.getStringExtra("note") ?: ""
        val quantity = intent.getIntExtra("quantity", 1)

        val noteCharge = if (note.isNotEmpty()) 150 else 0
        val wrappingCharge = if (wrapping != "None") 300 else 0
        val total = (bouquetPrice * quantity) + noteCharge + wrappingCharge
        val shipping = 300
        val subTotal = total + shipping

        // Bind values to summary
        findViewById<TextView>(R.id.tvCheckoutSummary).text =
            "Birthday Collection : $bouquetName - $bouquetSize, " +
                    (if (note.isNotEmpty()) "Note card, " else "") +
                    (if (wrapping != "None") "Wrapping $wrapping" else "")

        findViewById<TextView>(R.id.tvCheckoutTotal).text = "Total : Rs. $total/-"
        findViewById<TextView>(R.id.tvCheckoutShipping).text = "Shipping : Rs. $shipping/-"
        findViewById<TextView>(R.id.tvCheckoutSubTotal).text = "Sub Total : Rs. $subTotal/-"

        // Form fields
        val etName = findViewById<EditText>(R.id.etName)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etPaymentSlip = findViewById<EditText>(R.id.etPaymentSlip)

        // Place Order button
        findViewById<Button>(R.id.btnPlaceOrder).setOnClickListener {
            val name = etName.text.toString().trim()
            val address = etAddress.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val slip = etPaymentSlip.text.toString().trim()

            if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ✅ Current date
            val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            // ✅ Show confirmation popup
            AlertDialog.Builder(this)
                .setTitle("Order Placed")
                .setMessage("You have successfully placed the order 🎉")
                .setCancelable(false)
                .setPositiveButton("Go to Orders") { _, _ ->
                    val intent = Intent(this, OrdersActivity::class.java).apply {
                        putExtra("bouquetName", bouquetName)
                        putExtra("bouquetSize", bouquetSize)
                        putExtra("bouquetPrice", total) // send full total
                        putExtra("wrapping", wrapping)
                        putExtra("note", note)
                        putExtra("quantity", quantity)
                        putExtra("orderDate", currentDate)
                    }
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Close", null)
                .show()
        }
    }
}