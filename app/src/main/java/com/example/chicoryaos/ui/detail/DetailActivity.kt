package com.example.chicoryaos.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.example.chicoryaos.R
import com.example.chicoryaos.databinding.ActivityDetailBinding
import com.example.chicoryaos.util.binding.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initClickListener()
    }

    private fun initClickListener() {
        initPurchaseBtnClickListener()
        initBookmarkBtnClickListener()
    }

    private fun initBookmarkBtnClickListener() {
        binding.ivDetailBookmark.setOnClickListener {
            // TODO(북마크 클릭시)
        }
    }

    private fun initPurchaseBtnClickListener() {
        binding.btnDetailPurchase.setOnClickListener {
            // TODO(구매하기 클릭시)
        }
    }
}
