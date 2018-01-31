package com.github.teamapple.gencon.persentaion.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.extension.setupWithViewPager
import com.github.teamapple.gencon.persentaion.main.announce.AnnounceFragment
import com.github.teamapple.gencon.persentaion.main.events.EventsFragment
import com.github.teamapple.gencon.persentaion.main.tasks.TasksFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
        val adapter = BottomNavigationFragmentAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 3
        toolbar.title = bottomNavigation.let { menu -> menu.menu.findItem(menu.selectedItemId).title }
        bottomNavigation.setupWithViewPager(viewPager) { menuItem ->
            toolbar.title = menuItem.title
        }
    }

    class BottomNavigationFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        companion object {
            const val ITEM_COUNT = 3
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> EventsFragment.newInstance()
                1 -> TasksFragment.newInstance()
                2 -> AnnounceFragment()
                else -> throw IllegalAccessException("Illegal　position. position=$position")
            }
        }

        override fun getCount(): Int {
            return ITEM_COUNT
        }
    }
}
