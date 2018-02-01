package com.github.teamapple.gencon.persentaion.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.persentaion.main.announcement.AnnouncementFragment
import com.github.teamapple.gencon.persentaion.main.events.EventsFragment
import com.github.teamapple.gencon.persentaion.main.tasks.TasksFragment
import com.github.teamapple.gencon.util.ext.setupWithViewPager
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    /*val binding: Activity by lazy {

    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            fragmentDispatchingAndroidInjector

    class BottomNavigationFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        companion object {
            const val ITEM_COUNT = 3
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> EventsFragment.newInstance()
                1 -> TasksFragment.newInstance()
                2 -> AnnouncementFragment()
                else -> throw IllegalAccessException("Illegal　position. position=$position")
            }
        }

        override fun getCount(): Int {
            return ITEM_COUNT
        }
    }
}
