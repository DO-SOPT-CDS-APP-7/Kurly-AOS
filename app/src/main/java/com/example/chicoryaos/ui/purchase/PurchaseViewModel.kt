package com.example.chicoryaos.ui.purchase

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chicoryaos.util.extensions.PriceFormatter

class PurchaseViewModel : ViewModel() {
    var count = MutableLiveData<Int>()
    var price = 0

    val calculatePrice = MutableLiveData<String>()

    init {
        count.value = 1
        calculatePrice()
    }

    fun countIncrease() {
        count.value = count.value?.plus(1)
        calculatePrice()
    }

    fun countDecrease() {
        if (count.value!! > 1) {
            count.value = count.value?.minus(1)
        }
        calculatePrice()
    }

    private fun calculatePrice() {
        val totalCount = count.value ?: 0
        val totalPrice = totalCount * price
        val formatTotalPrice = PriceFormatter.formatPrice(totalPrice)
        calculatePrice.postValue(formatTotalPrice)
    }

    fun setPurchasePrice(newPrice: Int) {
        price = newPrice
        calculatePrice()
    }
}
