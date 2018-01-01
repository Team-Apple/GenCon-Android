package com.github.teamapple.gencon.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.extension.setupWithViewPager
import com.github.teamapple.gencon.ui.main.announce.AnnounceFragment
import com.github.teamapple.gencon.ui.main.events.EventsFragment
import com.github.teamapple.gencon.ui.main.tasks.TasksFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //private val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(binding.toolBar)
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
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, EventsFragment.newInstance())
                    .commit()
        }

        fab.setOnClickListener {
            /*val selectedFragment = adapter.getCurrentFragment()
            if (selectedFragment is BottomNavigationViewChild) {
                selectedFragment.onClickCreateFab()
            }*/
            val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
            if (fragment is BottomNavigationViewChild) {
                fragment.onClickCreateFab()
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

        //fun getCurrentFragment() = currentFragment

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
