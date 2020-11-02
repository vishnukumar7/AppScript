package com.android.vishnu.apps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.android.vishnu.apps.ui.QuestionOneFragment
import com.android.vishnu.apps.ui.QuestionThreeFragment
import com.android.vishnu.apps.ui.QuestionTwoFragment


class MainActivity : AppCompatActivity() {


    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewPager)
        setupViewPager(viewPager)


    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(QuestionOneFragment())
        adapter.addFragment(QuestionTwoFragment())
        adapter.addFragment(QuestionThreeFragment())
        viewPager.adapter = adapter
    }

    class ViewPagerAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val fragmentList: MutableList<Fragment> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment) {
            fragmentList.add(fragment)
        }
    }
}