package com.mangpofol.bookclub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mangpofol.bookclub.DTO.ClubDTO
import com.mangpofol.bookclub.databinding.BookClubListItemBinding

class ParticipateBookClubAdapter() :
    RecyclerView.Adapter<ParticipateBookClubAdapter.ParticipateBookClubViewHolder>() {
    private var clubs: List<ClubDTO> = arrayListOf(
        ClubDTO(clubName = "북클럽1"),
        ClubDTO(clubName = "북클럽2"),
        ClubDTO(clubName = "북클럽3")
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ParticipateBookClubViewHolder {
        val binding =
            BookClubListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParticipateBookClubViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParticipateBookClubViewHolder, position: Int) {
        holder.participateBookClubName.text = clubs[position].clubName
        holder.participateBookClubButton.text = "탈퇴"
    }

    override fun getItemCount(): Int {
        return clubs.size
    }

    class ParticipateBookClubViewHolder(itemView: BookClubListItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var participateBookClubName: TextView = itemView.bookClubTextView
        var participateBookClubButton: Button = itemView.bookClubButton
    }

}