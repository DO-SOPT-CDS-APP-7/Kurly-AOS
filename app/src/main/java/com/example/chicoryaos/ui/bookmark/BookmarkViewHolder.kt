package com.example.chicoryaos.ui.bookmark

import androidx.recyclerview.widget.RecyclerView
import com.example.chicoryaos.databinding.ItemBookmarkProductBinding
import com.example.chicoryaos.util.extensions.PriceFormatter

class BookmarkViewHolder(private val binding: ItemBookmarkProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(bookmarkData: Bookmark) {
        binding.ivItemWishList.setImageResource(bookmarkData.productImage)
        binding.tvItemWishListTitle.text = bookmarkData.productTitle
        binding.tvItemSalePrice.text = PriceFormatter.formatPrice(bookmarkData.productPrice) + "원"
    }
}
