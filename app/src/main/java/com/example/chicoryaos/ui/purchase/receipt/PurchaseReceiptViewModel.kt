package com.example.chicoryaos.ui.purchase.receipt

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chicoryaos.data.ApiFactory.ServicePool.authService
import com.example.chicoryaos.model.PriceEntity
import com.example.chicoryaos.util.extensions.PriceFormatter
import kotlinx.coroutines.launch

class PurchaseReceiptViewModel : ViewModel() {
    private val _count = MutableLiveData(1)
    val count: LiveData<Int>
        get() = _count

    private var originPrice = 0

    val calculatePrice = MutableLiveData<String>()
    var priceEntity: PriceEntity? = null

    private val _isSelectorChecked = MutableLiveData<Boolean>(false)
    val isSelectorChecked: LiveData<Boolean>
        get() = _isSelectorChecked

    init {
        updateTotalPrice()
    }

    fun deletePostPurchase() {
        _isSelectorChecked.value = false
        viewModelScope.launch {
            runCatching {
                authService.deletePostProduct(
                    1,
                )
            }.onSuccess {
                if (it.isSuccessful) {
                    Log.d("server delete success", it.code().toString())
                    _count.value = 0
                    originPrice = 0
                    updateTotalPrice()
                } else {
                    Log.d("server error", it.code().toString())
                }
            }.onFailure {
                Log.d("server fail", it.message.toString())
            }
        }
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
