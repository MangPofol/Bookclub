package com.mangpofol.bookclub

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.mangpofol.bookclub.databinding.ActivityMainBinding
import com.mangpofol.bookclub.databinding.NavigationViewRecycleView1Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var TAG: String = "MainActivity: "
    private var mDrawerToggle: ActionBarDrawerToggle? = null
    private var clubNames: MutableList<String> = mutableListOf("북클럽1", "북클럽2", "북클럽3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //drawer layout 초기 설정.
        mDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity, binding.drawerLayout, binding.toolbar, R.string.open, R.string.close)
        mDrawerToggle!!.syncState()

        binding.myBookClubHolderImage.setOnClickListener {
            if (binding.addBookClubButton.visibility==View.GONE) {
                setClubListView(clubNames)
                (it as ImageView).setImageResource(R.drawable.top_triangle)
            } else {
                (it as ImageView).setImageResource(R.drawable.down_triangle)
                binding.myBookClubContentsLayout.visibility = View.GONE
                binding.addBookClubButton.visibility = View.GONE
            }
        }

        setContentView(binding.root)
    }

    private fun setClubListView(clubNames: MutableList<String>) {
        binding.myBookClubContentsLayout.removeAllViews()
        binding.myBookClubContentsLayout.visibility = View.VISIBLE

        for (clubName in clubNames) {
            var bookclubBinding: NavigationViewRecycleView1Binding = NavigationViewRecycleView1Binding.inflate(layoutInflater)
            bookclubBinding.bookClubTextView.text = clubName
            bookclubBinding.bookClubButton.text = "삭제"

            binding.myBookClubContentsLayout.addView(bookclubBinding.clubListLayout)
        }

        binding.addBookClubButton.visibility = View.VISIBLE
    }

    override fun onBackPressed() {
        //drawer layout이 열려 있는 상태면 -> drawer layout 부터 닫는다.
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawers()
        else
            super.onBackPressed()
    }
}