package com.example.kotlinhomework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlinhomework3.fragments.HistoryFrag
import com.example.kotlinhomework3.fragments.OperationsFrag
import com.example.kotlinhomework3.fragments.ResultFrag
import com.example.kotlinhomework3.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val listOfFrag:ArrayList<Fragment> = arrayListOf(OperationsFrag(),ResultFrag(),HistoryFrag())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view_pagering.offscreenPageLimit = 3
        init()
        setPageSelected()
    }

    private fun setPageSelected() {
        view_pagering.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> botton_navigationn.menu.findItem(R.id.home_nav).isChecked = true
                    1 -> botton_navigationn.menu.findItem(R.id.notification_nav).isChecked = true
                    2 -> botton_navigationn.menu.findItem(R.id.profile_nav).isChecked = true
                }
            }
        })
    }

    private fun init() {
        view_pagering.adapter= ViewPagerAdapter(listOfFrag,supportFragmentManager,lifecycle)
        botton_navigationn.setOnNavigationItemSelectedListener {
           when(it.itemId){
               R.id.home_nav -> {
                   view_pagering.currentItem = 0
               }
               R.id.notification_nav -> {
                   view_pagering.currentItem = 1
               }
               R.id.profile_nav -> {
                   view_pagering.currentItem = 2
               }
           }
            true
        }
    }
}