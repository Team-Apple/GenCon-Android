package com.github.team_apple.gencon.presentation.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import com.github.team_apple.gencon.R
import com.github.team_apple.gencon.presentation.ui.main.events.EventsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar)
        val adapter = FragmentPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter

    }

    class FragmentPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        companion object {
            const val ITEM_COUNT = 3
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> EventsFragment.newInstance()
                1,2 -> TestFragment()
                else -> throw IllegalAccessException("illegal　position. position=$position")
            }
        }

        override fun getCount(): Int {
            return ITEM_COUNT
        }
    }
}
