package com.github.teamapple.gencon.persentaion.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.databinding.ActivityMainBinding
import com.github.teamapple.gencon.persentaion.main.announcement.AnnouncementsFragment
import com.github.teamapple.gencon.persentaion.main.events.EventsFragment
import com.github.teamapple.gencon.persentaion.main.task.TasksFragment
import com.github.teamapple.gencon.persentaion.taskDetail.TaskDetailActivity
import com.github.teamapple.gencon.util.ext.setupWithViewPager
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }

        val adapter = BottomNavigationFragmentAdapter(supportFragmentManager)
        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = 3
        binding.toolbar.title = binding.bottomNavigation.let { menu -> menu.menu.findItem(menu.selectedItemId).title }
        binding.bottomNavigation.setupWithViewPager(binding.viewPager) { menuItem ->
            binding.toolbar.title = menuItem.title
        }
        binding.eventsFab.setOnClickListener {
            startActivity(Intent(this,TaskDetailActivity::class.java))
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
                2 -> AnnouncementsFragment()
                else -> throw IllegalAccessException("Illegal　position. position=$position")
            }
        }

        override fun getCount(): Int {
            return ITEM_COUNT
        }
    }
}
