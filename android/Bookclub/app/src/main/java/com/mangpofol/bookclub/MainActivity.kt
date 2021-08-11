package com.mangpofol.bookclub

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mangpofol.bookclub.adapter.MyBookClubAdapter
import com.mangpofol.bookclub.adapter.ParticipateBookClubAdapter
import com.mangpofol.bookclub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myBookClubAdapter: MyBookClubAdapter
    private var mDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //나의 북클럽 리사이클러뷰 연결
        binding.myBookClubRecyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        binding.myBookClubRecyclerView.setHasFixedSize(true)

        //참여한 북클럽 리사이클러뷰 연결
        binding.participateBookClubRecyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        binding.participateBookClubRecyclerView.setHasFixedSize(true)

        initializeAdapter() //어댑터 선언&연결

        //drawer layout 초기 설정.
        mDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity, binding.drawerLayout, binding.toolbar, R.string.open, R.string.close
        )
        mDrawerToggle!!.syncState()

        //나의 북클럽 화살표 이미지 클릭했을 때 이벤트
        binding.myBookClubHolderImage.setOnClickListener {
            if (binding.myBookClubRecyclerView.visibility == View.GONE) {
                binding.BookClubCreateButton.visibility = View.VISIBLE
                binding.myBookClubRecyclerView.visibility = View.VISIBLE
            } else {
                binding.BookClubCreateButton.visibility = View.GONE
                binding.myBookClubRecyclerView.visibility = View.GONE
            }
        }

        //나의 북클럽 수가 3개 이상이면 북클럽 생성하기 버튼 비활성화
        binding.BookClubCreateButton.isEnabled = myBookClubAdapter.itemCount < 3

        //참여한 북클럽 화살표 이미지 클릭했을 때 이벤트
        binding.participateBookClubHolderImage.setOnClickListener {
            if (binding.participateBookClubRecyclerView.visibility == View.GONE) {
                binding.participateBookClubRecyclerView.visibility = View.VISIBLE
            } else {
                binding.participateBookClubRecyclerView.visibility = View.GONE
            }
        }
    }

    //어댑터 선언&연결
    private fun initializeAdapter() {
        myBookClubAdapter = MyBookClubAdapter()
        binding.myBookClubRecyclerView.adapter = myBookClubAdapter

        var participateBookClubAdapter: ParticipateBookClubAdapter = ParticipateBookClubAdapter()
        binding.participateBookClubRecyclerView.adapter = participateBookClubAdapter
    }

    override fun onBackPressed() {
        //drawer layout이 열려 있는 상태면 -> drawer layout 부터 닫는다.
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawers()
        else
            super.onBackPressed()
    }
}