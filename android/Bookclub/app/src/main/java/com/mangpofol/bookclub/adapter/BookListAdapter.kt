package com.mangpofol.bookclub.adapter

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mangpofol.bookclub.DTO.ClubDTO
import com.mangpofol.bookclub.databinding.BookClubListItemBinding
import com.mangpofol.bookclub.databinding.BookItemBinding
import org.w3c.dom.Text

class BookListAdapter() : RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {
    private val books: List<String> = arrayListOf(
        "7년의 밤",
        "나미야 잡화점의 기적",
        "몽환화",
        "동창생",
        "죽고싶지만 떡볶이는 먹고 싶어",
        "맥락을 팔아라",
        "없던 오늘"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val binding =
            BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bookName.text = books[position]
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BookListViewHolder(itemView: BookItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        val bookName: TextView = itemView.bookName
    }

    //아이템 간 수직(위아래) 간격 설정
    class VerticalItemDecorator(var divHeight: Int):RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect.top = divHeight
            outRect.bottom = divHeight
        }
    }

}