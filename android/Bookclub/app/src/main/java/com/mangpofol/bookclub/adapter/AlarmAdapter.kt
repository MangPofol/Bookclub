package com.mangpofol.bookclub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mangpofol.bookclub.DTO.AlarmDTO
import com.mangpofol.bookclub.databinding.AlarmItemBinding

class AlarmAdapter : RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {
    private val alarms: List<AlarmDTO> = arrayListOf(
        AlarmDTO(1, "북클럽1", "AA님께서 ‘7년의 밤’ 기록물에 댓글을 남기셨습니다.", "저도 그렇게 생각했어요. 역시 작가님은 천재~"),
        AlarmDTO(2, "북클럽2", "BB님께서 ‘7년의 밤’ 기록물에 좋아요를 남기셨습니다.", null)
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlarmAdapter.AlarmViewHolder {
        val binding = AlarmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlarmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlarmAdapter.AlarmViewHolder, position: Int) {
        holder.clubName.text = alarms[position].clubName
        holder.alarmTitle.text = alarms[position].alarmTitle
        if (alarms[position].alarmDescription != null) {
            holder.description.visibility = View.VISIBLE
            holder.description.text = alarms[position].alarmDescription
        }
    }

    override fun getItemCount(): Int {
        return alarms.size
    }

    class AlarmViewHolder(itemView: AlarmItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        val clubName: TextView = itemView.clubName
        val alarmTitle: TextView = itemView.alarmTitle
        val description: TextView = itemView.description
    }
}