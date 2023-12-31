package com.example.chicoryaos.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chicoryaos.data.ApiFactory.ServicePool.authService
import com.example.chicoryaos.model.ResponseProductDTO
import com.example.chicoryaos.model.ResponseRelatedDTO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class DetailViewModel() : ViewModel() {
    private val _product: MutableLiveData<ResponseProductDTO.Product> = MutableLiveData()
    val produce: LiveData<ResponseProductDTO.Product> = _product
    private val _relatedProductList: MutableLiveData<List<ResponseRelatedDTO.Data>> =
        MutableLiveData()
    val relatedProductList: LiveData<List<ResponseRelatedDTO.Data>> = _relatedProductList

    init {
        getProduct()
        getRelatedProductData()
    }

    private fun getProduct() {
        authService.getProduct(1).enqueue(
            object : Callback<ResponseProductDTO> {
                override fun onResponse(
                    call: Call<ResponseProductDTO>,
                    response: Response<ResponseProductDTO>
                ) {
                    if (response.isSuccessful) {
                        _product.value = response.body()?.data
                    }
                }

                override fun onFailure(call: Call<ResponseProductDTO>, t: Throwable) {
                    Timber.d("$t")
                }
            }
        )
    }

    private fun getRelatedProductData() {
        viewModelScope.launch {
            runCatching {
                authService.getRelatedProduct(1, 1, 6)
            }.onSuccess { response ->
                _relatedProductList.value = response.body()?.data
            }.onFailure { throwable ->
                Timber.d("$throwable")
            }
        }
    }
}
