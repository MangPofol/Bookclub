package com.mangpofol.bookclub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mangpofol.bookclub.DTO.ClubDTO
import com.mangpofol.bookclub.databinding.BookClubListItemBinding

class MyBookClubAdapter() : RecyclerView.Adapter<MyBookClubAdapter.MyBookClubViewHolder>() {
    private val clubs: List<ClubDTO> = arrayListOf(
        ClubDTO(clubName = "북클럽1"),
        ClubDTO(clubName = "북클럽2"),
        ClubDTO(clubName = "북클럽3")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBookClubViewHolder {
        val binding =
            BookClubListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyBookClubViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyBookClubViewHolder, position: Int) {
        holder.myBookClubName.text = clubs[position].clubName
        holder.myBookClubButton.text = "삭제"
    }

    override fun getItemCount(): Int {
        return clubs.size
    }

    class MyBookClubViewHolder(itemView: BookClubListItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var myBookClubName: TextView = itemView.bookClubTextView
        var myBookClubButton: Button = itemView.bookClubButton
    }

}