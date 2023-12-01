package com.example.chicoryaos.ui.purchase.receipt

import android.os.Bundle
import androidx.activity.viewModels
import com.example.chicoryaos.R
import com.example.chicoryaos.databinding.ActivityPurchaseReceiptBinding
import com.example.chicoryaos.model.PriceEntity
import com.example.chicoryaos.ui.purchase.PurchaseBasketFragment
import com.example.chicoryaos.util.binding.BindingActivity
import com.example.chicoryaos.util.extensions.getParcelable
import com.example.chicoryaos.util.snackBar

class PurchaseReceiptActivity :
    BindingActivity<ActivityPurchaseReceiptBinding>(R.layout.activity_purchase_receipt) {

    private val viewModel: PurchaseReceiptViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initGetIntent()
        initBackBtnClickListener()
        initDeleteBtnClickListener()
    }

    private fun initDeleteBtnClickListener() = with(binding) {
        tvReceiptChooseDelete.setOnClickListener {
            viewModel.deletePostPurchase()
            snackBar(binding.root, "장바구니에서 상품이 삭제되었습니다")
        }
    }

    private fun initDataBinding() {
        binding.lifecycleOwner = this
        binding.vm = viewModel
    }

    private fun initGetIntent() {
        val priceEntity =
            intent.getParcelable(PurchaseBasketFragment.TAG, PriceEntity::class.java)

        if (priceEntity != null) {
            with(viewModel) {
                setProductEntity(priceEntity)
                setPurchasePrice(priceEntity.discountedPrice)
            }
        }
    }

    private fun initBackBtnClickListener() {
        binding.btnReceiptBack.setOnClickListener {
            finish()
        }
    }
}
