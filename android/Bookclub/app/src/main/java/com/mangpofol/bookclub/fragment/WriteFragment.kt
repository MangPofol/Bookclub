package com.mangpofol.bookclub.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mancj.materialsearchbar.MaterialSearchBar
import com.mangpofol.bookclub.MainActivity
import com.mangpofol.bookclub.R
import com.mangpofol.bookclub.adapter.BookListAdapter
import com.mangpofol.bookclub.databinding.FragmentWriteBinding

class WriteFragment: Fragment() {
    private lateinit var binding: FragmentWriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteBinding.inflate(inflater, container, false)

        initializeAdapter()

        (activity as MainActivity).changeIcon(R.drawable.ic_baseline_change_history_36)

        binding.bookSearchBar.setOnSearchActionListener(object : MaterialSearchBar.OnSearchActionListener{
            override fun onButtonClicked(buttonCode: Int) {
                TODO("Not yet implemented")
            }
            //검색창 누른 상태 여부 확인
            override fun onSearchStateChanged(enabled: Boolean) {
                //맞으면 리스트뷰 보이게 설정
                if(enabled){
                    binding.bookRecyclerView.visibility = View.VISIBLE
                }else{ //아니면 안 보이게
                    binding.bookRecyclerView.visibility = View.GONE
                }
            }

            override fun onSearchConfirmed(text: CharSequence?) {
                TODO("Not yet implemented")
            }

        })

        binding.storeButton.setOnClickListener {
            val bottomSheet: BottomSheet = BottomSheet()
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
        }

        return binding.root
    }

    //어댑터 선언&연결
    private fun initializeAdapter() {
        var bookListAdapter: BookListAdapter = BookListAdapter()
        binding.bookRecyclerView.adapter = bookListAdapter
        binding.bookRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.bookRecyclerView.setHasFixedSize(true)
        binding.bookRecyclerView.addItemDecoration(BookListAdapter.VerticalItemDecorator(10))
    }
}