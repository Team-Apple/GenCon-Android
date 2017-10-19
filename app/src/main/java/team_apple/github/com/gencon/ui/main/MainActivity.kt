package team_apple.github.com.gencon.ui.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import team_apple.github.com.gencon.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar)
        val adapter = FragmentPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    class FragmentPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        companion object {
            const val ITEM_COUNT = 2
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> TodayEventFragment.newInstance()
                1 -> TomorrowEventFragment.newInstance()
                else -> throw IllegalAccessException("illegal　position. position=$position")
            }
        }

        override fun getCount(): Int {
            return ITEM_COUNT
        }

        override fun getPageTitle(position: Int): CharSequence {
            return when (position) {
                0 -> context.getString(R.string.today)
                1 -> context.getString(R.string.tomorrow)
                else -> throw IllegalAccessException("illegal　position. position=$position")
            }
        }
    }
}
