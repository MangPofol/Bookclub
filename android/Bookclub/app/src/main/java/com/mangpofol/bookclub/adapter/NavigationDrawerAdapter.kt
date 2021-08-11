package com.mangpofol.bookclub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mangpofol.bookclub.MainActivity
import com.mangpofol.bookclub.databinding.NavigationDrawerExpandableViewBinding

class NavigationDrawerAdapter() :
    RecyclerView.Adapter<NavigationDrawerAdapter.NavigationViewHolder>() {
    private val headerTitle: List<String> = listOf(
        "나의 북클럽",
        "참여한 북클럽",
        "알림"
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NavigationDrawerAdapter.NavigationViewHolder {
        val binding = NavigationDrawerExpandableViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NavigationViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NavigationDrawerAdapter.NavigationViewHolder,
        position: Int
    ) {
        val context: MainActivity = MainActivity()

        holder.headerTextView.text = headerTitle[position]

        when (position) {
            0 -> {
                val myBookClubAdapter: MyBookClubAdapter = MyBookClubAdapter()
                holder.recyclerView.adapter = myBookClubAdapter
                holder.recyclerView.setHasFixedSize(true)
                holder.recyclerView.layoutManager =
                    LinearLayoutManager(context.baseContext, LinearLayoutManager.VERTICAL, false)
                holder.createClubButton.visibility = View.VISIBLE
            }
            1 -> {
                val participateBookClubAdapter: ParticipateBookClubAdapter =
                    ParticipateBookClubAdapter()
                holder.recyclerView.adapter = participateBookClubAdapter
                holder.recyclerView.setHasFixedSize(true)
                holder.recyclerView.layoutManager =
                    LinearLayoutManager(context.baseContext, LinearLayoutManager.VERTICAL, false)
            }
            2 -> {
                val alarmAdapter: AlarmAdapter =
                    AlarmAdapter()
                holder.recyclerView.adapter = alarmAdapter
                holder.recyclerView.setHasFixedSize(true)
                holder.recyclerView.layoutManager =
                    LinearLayoutManager(context.baseContext, LinearLayoutManager.VERTICAL, false)
            }
        }

        holder.toggleButton.setOnClickListener {
            if (holder.expandView.visibility == View.GONE) {
                expand(holder.expandView)
                //toggleButton 위로 올라간 이미지로 변경
            } else {
                collapse(holder.expandView)
                //toggleButton 아래로 내려간 이미지로 변경
            }
        }
    }

    override fun getItemCount(): Int {
        return headerTitle.size
    }

    private fun expand(view: View) {
        val animation = expandAction(view)
        view.startAnimation(animation)
    }

    private fun expandAction(view: View): Animation {
        view.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val actualHeight = view.measuredHeight

        view.layoutParams.height = 0
        view.visibility = View.VISIBLE

        val animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                view.layoutParams.height =
                    if (interpolatedTime == 1f) ViewGroup.LayoutParams.WRAP_CONTENT
                    else (actualHeight * interpolatedTime).toInt()

                view.requestLayout()
            }
        }

        animation.duration = (actualHeight / view.context.resources.displayMetrics.density).toLong()

        view.startAnimation(animation)

        return animation
    }

    private fun collapse(view: View) {
        val actualHeight = view.measuredHeight

        val animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                if (interpolatedTime == 1f) {
                    view.visibility = View.GONE
                } else {
                    view.layoutParams.height =
                        (actualHeight - (actualHeight * interpolatedTime)).toInt()
                    view.requestLayout()
                }
            }
        }

        animation.duration = (actualHeight / view.context.resources.displayMetrics.density).toLong()
        view.startAnimation(animation)
    }

    class NavigationViewHolder(itemView: NavigationDrawerExpandableViewBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val toggleButton: ImageButton = itemView.toggleButton
        val headerTextView: TextView = itemView.headerTextView
        val expandView: LinearLayout = itemView.expandView
        val createClubButton: Button = itemView.createBookClubButton
        val recyclerView: RecyclerView = itemView.expandRecyclerView
    }
}