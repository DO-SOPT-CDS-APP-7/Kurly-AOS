package com.example.chicoryaos.ui.purchase.receipt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chicoryaos.model.PriceEntity
import com.example.chicoryaos.util.extensions.PriceFormatter

class PurchaseReceiptViewModel : ViewModel() {
    private val _count = MutableLiveData(1)
    val count: LiveData<Int>
        get() = _count

    private var originPrice = 0

    val calculatePrice = MutableLiveData<String>()
    var priceEntity: PriceEntity? = null

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
        val totalPrice = totalCount * originPrice
        val formatTotalPrice = PriceFormatter.formatPrice(totalPrice)
        calculatePrice.postValue(formatTotalPrice)
    }

    fun setPurchasePrice(newPrice: Int) {
        originPrice = newPrice
        updateTotalPrice()
    }

    fun setProductEntity(newPriceEntity: PriceEntity) {
        priceEntity = newPriceEntity
        _count.value = priceEntity?.count
    }
}
