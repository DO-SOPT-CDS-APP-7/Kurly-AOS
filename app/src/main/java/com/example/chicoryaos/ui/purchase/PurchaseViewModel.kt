package com.example.chicoryaos.ui.purchase

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PurchaseViewModel : ViewModel() {
    var count = MutableLiveData<Int>()
    var price = 0

    val calculatePrice = MutableLiveData<Int>()

    init {
        count.value = 1
        calculatePrice()
    }

    fun countIncrease() {
        count.postValue(count.value?.plus(1))
        calculatePrice()
    }

    fun countDecrease() {
        if (count.value!! > 1) {
            count.postValue(count.value?.minus(1))
        }
        calculatePrice()
    }

    private fun calculatePrice() {
        val totalCount = count.value ?: 0
        val totalPrice = totalCount * price
        calculatePrice.postValue(totalPrice)
    }

    fun setPurchasePrice(newPrice: Int) {
        price = newPrice
    }
}
