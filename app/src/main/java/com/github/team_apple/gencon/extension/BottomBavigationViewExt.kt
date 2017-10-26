package com.github.team_apple.gencon.extension

import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager

fun BottomNavigationView.setupWithViewPager(viewPager:ViewPager) {
    this.setOnNavigationItemSelectedListener { item->
        viewPager.adapter.get

    }
}
