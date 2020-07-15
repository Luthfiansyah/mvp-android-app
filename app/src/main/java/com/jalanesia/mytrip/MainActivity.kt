package com.jalanesia.mytrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import com.jalanesia.mytrip.utils.Auth

class MainActivity : AppCompatActivity() {

    private lateinit var homeBtn: ImageButton
    private lateinit var addBtn: ImageButton
    private lateinit var notiBtn: ImageButton
    private lateinit var searchBtn: ImageButton
    private lateinit var profileBtn: ImageButton

    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerViewAdapter: PagerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var auth = Auth()
        if (!auth.isLogin(this)){
            val intent = Intent(this@MainActivity,LoginActivity::class.java)
            startActivity(intent)
        }else {
            setContentView(R.layout.activity_main)
        }

//        NetworkConfig().getService()
//        .getUsers()
//        .enqueue(object : Callback<List<UserItem>> {
//            override fun onFailure(call: Call<List<UserItem>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(
//                call: Call<List<UserItem>>,
//                response: Response<List<UserItem>>
//            ) {
//                rvUser.adapter =
//                    UsersAdapter(response.body())
//            }
//        })

        // init views

        mViewPager = findViewById(R.id.mViewPager)
        homeBtn = findViewById(R.id.homeBtn)
        addBtn = findViewById(R.id.addBtn)
        profileBtn = findViewById(R.id.profileBtn)
        searchBtn = findViewById(R.id.searchBtn)
        notiBtn = findViewById(R.id.notiBtn)


        //onclick listner
        homeBtn.setOnClickListener {
            mViewPager.currentItem = 0
        }

        searchBtn.setOnClickListener {
            mViewPager.currentItem = 1
        }

        addBtn.setOnClickListener {
            mViewPager.currentItem = 2
        }

        notiBtn.setOnClickListener {
            mViewPager.currentItem = 3
        }

        profileBtn.setOnClickListener {
            mViewPager.currentItem = 4
        }

        mPagerViewAdapter = PagerViewAdapter(supportFragmentManager)
        mViewPager.adapter = mPagerViewAdapter
        mViewPager.offscreenPageLimit = 5

        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                changeTabs(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        mViewPager.currentItem = 0
        homeBtn.setImageResource(R.drawable.ic_home_pink)

    }

    private fun changeTabs(position: Int) {

        if (position == 0) {
            homeBtn.setImageResource(R.drawable.ic_home_pink)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            addBtn.setImageResource(R.drawable.ic_add_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)
        }

        if (position == 1) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_pink)
            addBtn.setImageResource(R.drawable.ic_add_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)
        }

        if (position == 2) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            addBtn.setImageResource(R.drawable.ic_add_pink)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)
        }

        if (position == 3) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            addBtn.setImageResource(R.drawable.ic_add_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_fill)
            profileBtn.setImageResource(R.drawable.ic_person_outline_)
        }

        if (position == 4) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            addBtn.setImageResource(R.drawable.ic_add_black)
            notiBtn.setImageResource(R.drawable.ic_notifications_blck)
            profileBtn.setImageResource(R.drawable.ic_person_pink_fill)
        }
    }
}
