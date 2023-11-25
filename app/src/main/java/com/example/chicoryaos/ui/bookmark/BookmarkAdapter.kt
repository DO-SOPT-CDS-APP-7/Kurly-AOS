package com.example.chicoryaos.ui.bookmark

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chicoryaos.databinding.ItemBookmarkProductBinding

class BookmarkAdapter(context: Context) : RecyclerView.Adapter<BookmarkViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var bookmarkList: List<Bookmark> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val binding = ItemBookmarkProductBinding.inflate(inflater, parent, false)
        return BookmarkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.onBind(bookmarkList[position])
    }

    override fun getItemCount() = bookmarkList.size

    fun setBookmarkList(bookmarkList: List<Bookmark>) {
        this.bookmarkList = bookmarkList.toList()
        notifyDataSetChanged()
    }
}
