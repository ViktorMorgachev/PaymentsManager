package com.sedi.viktor.paymentsmanager.ui

import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private var icons: List<Drawable> = mutableListOf()

    override fun getItemCount(): Int {
        return icons.size
    }

    public fun setIcons(icons: ArrayList<Drawable>): FragmentAdapter {
        this.icons = icons
        return this
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainFragment()
            1 -> MessagingFragment.newInstance()
            else -> MainFragment()
        }
    }
}