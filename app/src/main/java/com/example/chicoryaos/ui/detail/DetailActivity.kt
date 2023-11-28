package com.example.chicoryaos.ui.detail

import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import androidx.activity.viewModels
import com.example.chicoryaos.R
import com.example.chicoryaos.databinding.ActivityDetailBinding
import com.example.chicoryaos.util.binding.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initClickListener()
        viewModel.produce.observe(this) {
            Log.e("kang", viewModel.produce.value.toString())
        }
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
            // TODO(북마크 클릭시)
        }
    }

    private fun initPurchaseBtnClickListener() {
        binding.btnDetailPurchase.setOnClickListener {
            // TODO(구매하기 클릭시)
        }
    }
}
