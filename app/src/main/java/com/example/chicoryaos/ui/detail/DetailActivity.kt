package com.example.chicoryaos.ui.detail

import android.os.Bundle
import com.example.chicoryaos.R
import com.example.chicoryaos.databinding.ActivityDetailBinding
import com.example.chicoryaos.ui.purchase.PurchaseFragment
import com.example.chicoryaos.util.binding.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
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
            // TODO(북마크 클릭시)
        }
    }

    private fun initPurchaseBtnClickListener() {
        binding.btnDetailPurchase.setOnClickListener {
            // TODO(구매하기 클릭시)
            val purchaseBottomSheet = PurchaseFragment()
            purchaseBottomSheet.show(supportFragmentManager, PurchaseFragment.TAG)
        }
    }
}
