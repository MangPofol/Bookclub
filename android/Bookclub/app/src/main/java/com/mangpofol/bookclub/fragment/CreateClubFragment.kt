package com.mangpofol.bookclub.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mangpofol.bookclub.MainActivity
import com.mangpofol.bookclub.R
import com.mangpofol.bookclub.databinding.FragmentCreateClubBinding
import com.mangpofol.bookclub.databinding.FragmentWriteBinding

class CreateClubFragment: Fragment() {
    private lateinit var binding: FragmentCreateClubBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateClubBinding.inflate(inflater, container, false)

        (activity as MainActivity).changeIcon(R.drawable.ic_baseline_create_36)

        return binding.root
    }
}