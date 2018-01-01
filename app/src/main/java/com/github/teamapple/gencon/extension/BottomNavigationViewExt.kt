package com.github.teamapple.gencon.extension

import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.github.teamapple.widget.FixedViewPager

fun BottomNavigationView.setupWithViewPager(viewPager: FixedViewPager ,onSelect:(MenuItem) -> Unit) {
    val menuItems = 0.until(this.menu.size()).map { index-> this.menu.getItem(index) }
    setOnNavigationItemSelectedListener { menuItem->
        val index = menuItems.indexOf(menuItem)
        if(index >= 0){
            viewPager.setCurrentItem(index,false)
            onSelect(menuItem)
        }
        true
    }
}
