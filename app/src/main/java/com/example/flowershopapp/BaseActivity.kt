package com.example.flowershopapp

import android.content.Intent
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // ───────── Bottom Navigation ─────────
    protected fun setupBottomNav() {
        val navHome = findViewById<TextView>(R.id.navHome)
        val navDeals = findViewById<TextView>(R.id.navDeals)
        val navCart = findViewById<TextView>(R.id.navCart)
        val navProfile = findViewById<TextView>(R.id.navProfile)

        navHome?.setOnClickListener {
            if (this !is HomeActivity) {
                startActivity(Intent(this, HomeActivity::class.java))
                overridePendingTransition(0, 0)
            }
        }

        navDeals?.setOnClickListener {
            if (this !is DealsActivity) {
                startActivity(Intent(this, DealsActivity::class.java))
                overridePendingTransition(0, 0)
            }
        }

        navCart?.setOnClickListener {
            if (this !is CartActivity) {
                startActivity(Intent(this, CartActivity::class.java))
                overridePendingTransition(0, 0)
            }
        }

        navProfile?.setOnClickListener {
            if (this !is ProfileActivity) {
                startActivity(Intent(this, ProfileActivity::class.java))
                overridePendingTransition(0, 0)
            }
        }
    }

    // ───────── Top Navigation ─────────
    protected fun setupTopNav() {
        val icoMenu = findViewById<TextView>(R.id.icoMenu)
        val icoSearch = findViewById<TextView>(R.id.icoSearch)
        val btnOccasions = findViewById<MaterialButton>(R.id.btnOccasions)

        // ─── Menu (left hamburger) ───
        icoMenu?.setOnClickListener {
            val popup = PopupMenu(this, icoMenu)
            val mainMenu = resources.getStringArray(R.array.main_menu)

            mainMenu.forEachIndexed { index, item ->
                popup.menu.add(0, index, index, item)
            }

            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.title.toString()) {
                    getString(R.string.menu_seasonal) ->
                        showSubMenu(menuItem.title.toString(), R.array.seasonal_list, icoMenu)
                    getString(R.string.menu_occasions) ->
                        showSubMenu(menuItem.title.toString(), R.array.occasions_list, icoMenu)
                    else ->
                        Toast.makeText(this, "Selected: ${menuItem.title}", Toast.LENGTH_SHORT).show()
                }
                true
            }

            popup.show()
        }

        // ─── Occasions dropdown ───
        btnOccasions?.setOnClickListener {
            val popup = PopupMenu(this, btnOccasions)
            val occasions = resources.getStringArray(R.array.occasions_list)

            occasions.forEachIndexed { index, item ->
                popup.menu.add(0, index, index, item)
            }

            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.title.toString()) {
                    "Birthdays" -> {
                        // ✅ Navigate to BirthdayActivity from any page
                        if (this !is BirthdayActivity) {
                            startActivity(Intent(this, BirthdayActivity::class.java))
                            overridePendingTransition(0, 0)
                        }
                    }
                    else -> {
                        Toast.makeText(this, "Selected: ${menuItem.title}", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }

            popup.show()
        }

        // ─── Search (right) ───
        icoSearch?.setOnClickListener {
            if (this !is SearchActivity) {
                startActivity(Intent(this, SearchActivity::class.java))
                overridePendingTransition(0, 0)
            }
        }
    }

    // ─── Helper for nested submenus ───
    protected fun showSubMenu(title: String, arrayRes: Int, anchor: TextView) {
        val popup = PopupMenu(this, anchor)
        val subItems = resources.getStringArray(arrayRes)

        subItems.forEachIndexed { index, item ->
            popup.menu.add(0, index, index, item)
        }

        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.title.toString()) {
                "Birthdays" -> {
                    // ✅ Also handle inside submenu
                    if (this !is BirthdayActivity) {
                        startActivity(Intent(this, BirthdayActivity::class.java))
                        overridePendingTransition(0, 0)
                    }
                }
                else -> {
                    Toast.makeText(this, "$title → ${menuItem.title}", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        popup.show()
    }
}