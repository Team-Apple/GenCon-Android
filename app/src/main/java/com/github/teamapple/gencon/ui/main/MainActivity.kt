package com.github.teamapple.gencon.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.databinding.ActivityMainBinding
import com.github.teamapple.gencon.extension.setupWithViewPager
import com.github.teamapple.gencon.ui.main.announce.AnnounceFragment
import com.github.teamapple.gencon.ui.main.events.EventsFragment
import com.github.teamapple.gencon.ui.main.tasks.TasksFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolBar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
        val adapter = BottomNavigationFragmentAdapter(supportFragmentManager)
        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = 3
        binding.toolBar.title = binding.bottomNavigation.let { menu -> menu.menu.findItem(menu.selectedItemId).title }
        binding.bottomNavigation.setupWithViewPager(binding.viewPager) { menuItem ->
            binding.toolBar.title = menuItem.title
        }

        binding.floatingActionButton.setOnClickListener {
            val selectedFragment = adapter.getCurrentFragment()
            if (selectedFragment is BottomNavigationViewChild) {
                selectedFragment.onClickCreateButton()
            }
        }
    }

    class BottomNavigationFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
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
                1 -> TasksFragment.newInstance()
                2 -> AnnounceFragment()
                else -> throw IllegalAccessException("illegal　position. position=$position")
            }
        }

        override fun getCount(): Int {
            return ITEM_COUNT
        }
    }
}
