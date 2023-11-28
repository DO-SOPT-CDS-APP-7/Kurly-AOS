package com.example.chicoryaos.ui.purchase.receipt

import android.os.Bundle
import com.example.chicoryaos.R
import com.example.chicoryaos.databinding.ActivityPurchaseReceiptBinding
import com.example.chicoryaos.util.binding.BindingActivity

class PurchaseReceiptActivity :
    BindingActivity<ActivityPurchaseReceiptBinding>(R.layout.activity_purchase_receipt) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initGetIntent()
    }

    private fun initGetIntent() {
    }
}
