package com.example.chicoryaos.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chicoryaos.data.ApiFactory.ServicePool.authService
import com.example.chicoryaos.model.ResponseRelatedDTO
import kotlinx.coroutines.launch
import timber.log.Timber

class BookmarkViewModel : ViewModel() {

    private val _relatedProduct: MutableLiveData<List<ResponseRelatedDTO.Data>> =
        MutableLiveData()
    val relatedProduct: LiveData<List<ResponseRelatedDTO.Data>> = _relatedProduct

    private val _recommendProduct: MutableLiveData<List<ResponseRelatedDTO.Data>> =
        MutableLiveData()
    val recommendProduct: LiveData<List<ResponseRelatedDTO.Data>> = _recommendProduct

    init {
        getRelatedBookmarkProductData()
        getRecommendBookmarkProductData()
    }

    private fun getRelatedBookmarkProductData() {
        viewModelScope.launch {
            kotlin.runCatching {
                authService.getRelatedProduct(1, 3, 3)
            }.onSuccess {
                if (it.isSuccessful) {
                    _relatedProduct.value = it.body()?.data
                } else {
                    Timber.d("server error", it.code().toString())
                }
            }.onFailure {
                Timber.d("server fail", it.message.toString())
            }
        }
    }

    private fun getRecommendBookmarkProductData() {
        viewModelScope.launch {
            kotlin.runCatching {
                authService.getRecommendBookmarkProduct(1)
            }.onSuccess {
                if (it.isSuccessful) {
                    _recommendProduct.value = it.body()?.data
                } else {
                    Timber.d("server error", it.code().toString())
                }
            }.onFailure {
                Timber.d("server fail", it.message.toString())
            }
        }
    }
}
