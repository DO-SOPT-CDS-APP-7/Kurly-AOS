package com.example.chicoryaos.ui.detail

import CustomBookmarkSnackbar
import android.os.Bundle
import com.example.chicoryaos.R
import com.example.chicoryaos.databinding.ActivityDetailBinding
import com.example.chicoryaos.util.binding.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private var isBookmarked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClickListener()
    }

    private fun initClickListener() {
        initPurchaseBtnClickListener()
        initBookmarkBtnClickListener()
    }

    private fun initBookmarkBtnClickListener() {
        binding.ivDetailBookmark.setOnClickListener {
            isBookmarked = !isBookmarked

            if (isBookmarked) {
                CustomBookmarkSnackbar.showBookmarkAddSnackbar(
                    findViewById(android.R.id.content),
                    this,
                )
            } else {
                CustomBookmarkSnackbar.showBookmarkDeleteSnackbar(
                    findViewById(android.R.id.content),
                    this,
                )
            }
        }
    }

    private fun initPurchaseBtnClickListener() {
        binding.btnDetailPurchase.setOnClickListener {
            // TODO(구매하기 클릭시)
        }
    }
}
