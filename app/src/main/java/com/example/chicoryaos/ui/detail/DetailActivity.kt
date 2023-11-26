package com.example.chicoryaos.ui.detail

import android.os.Bundle
import android.widget.Toast
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
            if (isBookmarked) {
                showToast(R.layout.toast_bookmark_delete)
            } else {
                showToast(R.layout.toast_bookmark_add)
            }
            isBookmarked = !isBookmarked
        }
    }

    private fun initPurchaseBtnClickListener() {
        binding.btnDetailPurchase.setOnClickListener {
            // TODO(구매하기 클릭시)
        }
    }

    private fun showToast(layoutId: Int) {
        val inflater = layoutInflater
        val layout = inflater.inflate(layoutId, findViewById(R.id.custom_toast_container))
        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }
}
