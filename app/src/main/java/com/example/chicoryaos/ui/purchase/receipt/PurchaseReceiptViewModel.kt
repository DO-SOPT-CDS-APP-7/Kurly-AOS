package com.example.chicoryaos.ui.purchase.receipt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chicoryaos.util.extensions.PriceFormatter

class PurchaseReceiptViewModel : ViewModel() {
    val count = MutableLiveData<Int>(1)
    private var originPrice = 0

    val calculatePrice = MutableLiveData<String>()

    init {
        updateTotalPrice()
    }

    fun countIncrease() {
        count.value = count.value?.plus(1)
        updateTotalPrice()
    }

    fun countDecrease() {
        if (count.value!! > 1) {
            count.value = count.value?.minus(1)
        }
        updateTotalPrice()
    }

    private fun updateTotalPrice() {
        val totalCount = count.value ?: 0
        val totalPrice = totalCount * originPrice
        val formatTotalPrice = PriceFormatter.formatPrice(totalPrice)
        calculatePrice.postValue(formatTotalPrice)
    }

    fun setPurchasePrice(newPrice: Int) {
        originPrice = newPrice
        updateTotalPrice()
    }
}
