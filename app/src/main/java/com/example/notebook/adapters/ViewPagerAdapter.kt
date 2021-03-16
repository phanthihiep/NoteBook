package com.example.notebook.adapters

import android.view.View
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter: PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("Not yet implemented")
    }

    override fun getCount() = 5

    fun getFragment(position: Int) {

    }
}