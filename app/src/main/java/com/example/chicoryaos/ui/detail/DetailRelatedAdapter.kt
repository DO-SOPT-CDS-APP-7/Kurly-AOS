package com.example.chicoryaos.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chicoryaos.databinding.ItemProductRelatedBinding
import com.example.chicoryaos.model.ResponseRelatedDTO
import com.example.chicoryaos.util.ItemDiffCallback

class DetailRelatedAdapter :
    ListAdapter<ResponseRelatedDTO.Data, DetailRelatedAdapter.DetailRelatedViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailRelatedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemRecommendProfileBinding =
            ItemProductRelatedBinding.inflate(layoutInflater, parent, false)
        return DetailRelatedViewHolder(itemRecommendProfileBinding)
    }

    override fun onBindViewHolder(holder: DetailRelatedViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class DetailRelatedViewHolder(private val binging: ItemProductRelatedBinding) :
        RecyclerView.ViewHolder(binging.root) {
        fun onBind(data: ResponseRelatedDTO.Data) {
            binging.product = data
        }
    }

    companion object {
        private val DIFF_CALLBACK = ItemDiffCallback<ResponseRelatedDTO.Data>(
            onItemsTheSame = { old, new -> old.productName == new.productName },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}