package com.example.chicoryaos.ui.purchase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chicoryaos.data.ApiFactory.ServicePool.authService
import com.example.chicoryaos.model.ResponseRelatedDTO
import com.example.chicoryaos.util.extensions.PriceFormatter
import kotlinx.coroutines.launch

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

    // 서버 연결 저장하는 변수
    private val _product: MutableLiveData<List<ResponseRelatedDTO.Data>> = MutableLiveData()
    val product: LiveData<List<ResponseRelatedDTO.Data>> = _product

    init {
        getRelatedProductData()
        updateTotalPrice()
    }

    private fun getRelatedProductData() {
        viewModelScope.launch {
            kotlin.runCatching {
                authService.getRelatedProduct(1, 1, 3)
            }.onSuccess {
                if (it.isSuccessful) {
                    _product.value = it.body()?.data
                } else {
                    Log.d("server error", it.code().toString())
                }
            }.onFailure {
                Log.d("server fail", it.message.toString())
            }
        }
    }

    private fun updateTotalPrice() {
        val totalCount = _count.value ?: 0
        val totalPrice = totalCount * price
        val formatTotalPrice = PriceFormatter.formatPrice(totalPrice)
        calculatePrice.postValue(formatTotalPrice)
        setPurchaseProgress(totalPrice)
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
