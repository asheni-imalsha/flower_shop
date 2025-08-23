package com.example.flowershopapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class OnboardingActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager2
    private lateinit var dotsLayout: LinearLayout
    private lateinit var adapter: OnboardingAdapter
    private var dots: Array<ImageView?> = emptyArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding)

        pager = findViewById(R.id.pager)
        dotsLayout = findViewById(R.id.dots)

        adapter = OnboardingAdapter(this, pager)
        pager.adapter = adapter
        pager.isUserInputEnabled = false  // disable swipe, buttons control navigation

        setupDots(adapter.itemCount)
        updateDots(0)

        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateDots(position)
            }
        })
    }

    private fun setupDots(count: Int) {
        dots = arrayOfNulls(count)
        dotsLayout.removeAllViews()

        for (i in 0 until count) {
            dots[i] = ImageView(this).apply {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        this@OnboardingActivity,
                        R.drawable.dot_inactive
                    )
                )
                val params = LinearLayout.LayoutParams(24, 24)
                params.marginStart = 8
                params.marginEnd = 8
                layoutParams = params
            }
            dotsLayout.addView(dots[i])
        }
    }

    private fun updateDots(position: Int) {
        for (i in dots.indices) {
            dots[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    if (i == position) R.drawable.dot_active else R.drawable.dot_inactive
                )
            )
        }
    }
}