package com.github.team_apple.gencon.extension

import android.support.design.widget.BottomNavigationView
import com.github.team_apple.gencon.presentation.util.customview.FixedViewPager

fun BottomNavigationView.setupWithViewPager(viewPager:FixedViewPager) {
    val menuItems = 0.until(this.menu.size()).map { index-> this.menu.getItem(index) }
    this.setOnNavigationItemSelectedListener { menuItem->
        val index = menuItems.indexOf(menuItem)
        if(index >= 0){
            viewPager.setCurrentItem(index,false)
        }
        true
    }
}
