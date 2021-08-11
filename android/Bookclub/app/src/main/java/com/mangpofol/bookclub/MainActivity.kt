package com.mangpofol.bookclub

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mangpofol.bookclub.adapter.MyBookClubAdapter
import com.mangpofol.bookclub.databinding.ActivityMainBinding
import com.mangpofol.bookclub.adapter.NavigationDrawerAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myBookClubAdapter: MyBookClubAdapter
    private var mDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeAdapter() //어댑터 선언&연결

        //drawer layout 초기 설정.
        mDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity, binding.drawerLayout, binding.toolbar, R.string.open, R.string.close
        )
        mDrawerToggle!!.syncState()
    }

    //어댑터 선언&연결
    private fun initializeAdapter() {
        var navigationAdapter: NavigationDrawerAdapter = NavigationDrawerAdapter()
        binding.ExpandableView.adapter = navigationAdapter
        binding.ExpandableView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        binding.ExpandableView.setHasFixedSize(true)
    }

    override fun onBackPressed() {
        //drawer layout이 열려 있는 상태면 -> drawer layout 부터 닫는다.
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawers()
        else
            super.onBackPressed()
    }
}