package com.example.chicoryaos.ui.detail

import BookmarkFragment
import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import androidx.activity.viewModels
import com.example.chicoryaos.R
import com.example.chicoryaos.databinding.ActivityDetailBinding
import com.example.chicoryaos.ui.purchase.PurchaseFragment
import com.example.chicoryaos.util.CustomBookmarkSnackbar
import com.example.chicoryaos.util.binding.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val viewModel by viewModels<DetailViewModel>()
    private var detailRelatedAdapter: DetailRelatedAdapter? = null
    private var isBookmarked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initRecommendProfileAdapter()
        initClickListener()
        initProductListObserver()
    }

    private fun initRecommendProfileAdapter() {
        detailRelatedAdapter = DetailRelatedAdapter()
        binding.rvDetailOtherConsumer.adapter = detailRelatedAdapter
    }

    private fun initProductListObserver() {
        viewModel.relatedProductList.observe(this) {
            submitHomeProfileAdapterList()
        }
    }

    private fun submitHomeProfileAdapterList() {
        detailRelatedAdapter?.submitList(viewModel.relatedProductList.value)
    }

    private fun initClickListener() {
        initPurchaseBtnClickListener()
        initBookmarkBtnClickListener()
        initFabBtnClickListener()
    }

    private fun initFabBtnClickListener() {
        val scroll = { focus: Int -> binding.scrollView.fullScroll(focus) }
        binding.btnDetailFabUp.setOnClickListener {
            scroll(ScrollView.FOCUS_UP)
        }
        binding.btnDetailFabDown.setOnClickListener {
            scroll(ScrollView.FOCUS_DOWN)
        }
    }

    private fun initBookmarkBtnClickListener() {
        binding.ivDetailBookmark.setOnClickListener {
            isBookmarked = !isBookmarked
            val bookmarkBottomSheet = BookmarkFragment()

            if (isBookmarked) {
                binding.ivDetailBookmark.setImageResource(R.drawable.ic_button_pressed_full)
                bookmarkBottomSheet.show(supportFragmentManager, BookmarkFragment.TAG)
            } else {
                binding.ivDetailBookmark.setImageResource(R.drawable.ic_button_pressed)
                CustomBookmarkSnackbar.showBookmarkDeleteSnackbar(binding.root, this)
            }
        }
    }

    private fun initPurchaseBtnClickListener() {
        binding.btnDetailPurchase.setOnClickListener {
            val purchaseBottomSheet = PurchaseFragment()
            purchaseBottomSheet.show(supportFragmentManager, PurchaseFragment.TAG)
        }
    }
}
