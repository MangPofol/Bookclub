package com.mangpofol.bookclub

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mangpofol.bookclub.adapter.MyBookClubAdapter
import com.mangpofol.bookclub.databinding.ActivityMainBinding
import com.mangpofol.bookclub.adapter.NavigationDrawerAdapter
import com.mangpofol.bookclub.fragment.CreateClubFragment
import com.mangpofol.bookclub.fragment.WriteFragment


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

        //메인 화면 : 북클럽 생성 화면
        changeFragment(CreateClubFragment())

        //글쓰기 아이콘 버튼 누르면 글작성 화면으로 이동
        binding.writeButton.setOnClickListener {
            binding.bottomAppBar.setBackgroundColor(baseContext.resources.getColor(R.color.toolbar))
            changeFragment(WriteFragment())
        }
    }

    //어댑터 선언&연결
    private fun initializeAdapter() {
        var navigationAdapter: NavigationDrawerAdapter = NavigationDrawerAdapter()
        binding.ExpandableView.adapter = navigationAdapter
        binding.ExpandableView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        binding.ExpandableView.setHasFixedSize(true)
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right)
            .replace(binding.frameLayout.id, fragment).addToBackStack(null).commit()
        supportFragmentManager.beginTransaction().isAddToBackStackAllowed
    }

    fun changeIcon(drawableSource: Int) {
        binding.writeButton.background = getDrawable(drawableSource)
    }

    override fun onBackPressed() {
        //drawer layout이 열려 있는 상태면 -> drawer layout 부터 닫는다.
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawers()
        else {
            Log.d("현재 프래그먼트", (supportFragmentManager.findFragmentById(binding.frameLayout.id) is WriteFragment).toString())
            super.onBackPressed()
        }

    }
}