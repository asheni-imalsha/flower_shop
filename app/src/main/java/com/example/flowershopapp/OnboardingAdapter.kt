package com.example.flowershopapp

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class OnboardingAdapter(
    private val activity: Activity,
    private val pager: ViewPager2
) : RecyclerView.Adapter<OnboardingAdapter.VH>() {

    override fun getItemCount() = 2 // only 2 pages
    override fun getItemViewType(position: Int) = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutRes = if (viewType == 0) {
            R.layout.activity_welcome   // Page 1
        } else {
            R.layout.activity_discover  // Page 2
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val possibleBtnIds = intArrayOf(
            R.id.btnGetStarted, // welcome screen button
            R.id.btnStart       // discover screen button
        )

        var cta: MaterialButton? = null
        for (id in possibleBtnIds) {
            val found = holder.itemView.findViewById<MaterialButton?>(id)
            if (found != null) {
                cta = found
                break
            }
        }

        cta?.setOnClickListener {
            if (position == 0) {
                pager.currentItem = 1 // Page 1 → Page 2
            } else {
                // Page 2 → Go to SignUpActivity (or HomeActivity)
                val intent = Intent(activity, SignUpActivity::class.java)
                activity.startActivity(intent)
                activity.finish()
            }
        }
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView)
}