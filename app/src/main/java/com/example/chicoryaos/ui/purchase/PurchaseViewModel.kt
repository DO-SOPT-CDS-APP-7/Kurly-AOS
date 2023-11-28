package com.example.chicoryaos.ui.purchase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chicoryaos.util.extensions.PriceFormatter

class PurchaseViewModel : ViewModel() {
    private val _count = MutableLiveData(1)
    val count: LiveData<Int>
        get() = _count
    var price = 0

    val calculatePrice = MutableLiveData<String>()

    private val _purchaseProgress = MutableLiveData<Int>()
    val purchaseProgress: LiveData<Int>
        get() = _purchaseProgress

    private val _freePrice = MutableLiveData<Int>()
    val freePrice: LiveData<Int>
        get() = _freePrice

    init {
        updateTotalPrice()
    }

    fun countIncrease() {
        _count.value = _count.value?.plus(1)
        updateTotalPrice()
    }

    fun countDecrease() {
        if (_count.value!! > 1) {
            _count.value = _count.value?.minus(1)
        }
        updateTotalPrice()
    }

    private fun updateTotalPrice() {
        val totalCount = _count.value ?: 0
        val totalPrice = totalCount * price
        val formatTotalPrice = PriceFormatter.formatPrice(totalPrice)
        calculatePrice.postValue(formatTotalPrice)
        setPurchaseProgress(totalPrice)
    }

    fun setPurchasePrice(newPrice: Int) {
        price = newPrice
        updateTotalPrice()
    }

    private fun setPurchaseProgress(totalPrice: Int) {
        val maxTotalPrice = 15000
        _purchaseProgress.value = (totalPrice * 100) / maxTotalPrice
        _freePrice.value = maxOf(0, maxTotalPrice - totalPrice)
    }
}
