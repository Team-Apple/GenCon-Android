package com.github.teamapple.gencon.presentation.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.extension.setupWithViewPager
import com.github.teamapple.gencon.presentation.ui.main.events.EventsFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.threeten.bp.LocalDate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolBar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
        val adapter = FragmentPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter

        val today = LocalDate.now()

        bottomNavigationView.setupWithViewPager(viewPager)
        /*fab.setOnClickListener {
            val selectedFragment = adapter.getCurrentFragment()
            if (selectedFragment is ParentEventSubscriber){
                selectedFragment.onClickCreateButton()
            }
        }*/
    }

    class FragmentPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        companion object {
            const val ITEM_COUNT = 3
        }
        private var currentFragment: Fragment? = null
        override fun setPrimaryItem(container: ViewGroup?, position: Int, obj: Any?) {
            if (currentFragment !== obj) {
                currentFragment = obj as? Fragment
            }
            super.setPrimaryItem(container, position, obj)
        }

        fun getCurrentFragment() = currentFragment

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> EventsFragment.newInstance()
                1, 2 -> TestFragment()
                else -> throw IllegalAccessException("illegal　position. position=$position")
            }
        }

        override fun getCount(): Int {
            return ITEM_COUNT
        }
    }
}
