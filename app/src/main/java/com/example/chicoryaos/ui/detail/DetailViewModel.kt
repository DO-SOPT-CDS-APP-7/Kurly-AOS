package com.example.chicoryaos.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chicoryaos.data.ApiFactory.ServicePool.authService
import com.example.chicoryaos.model.ResponseProductDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class DetailViewModel() : ViewModel() {
    private val _product: MutableLiveData<ResponseProductDTO.Product> = MutableLiveData()
    val produce: LiveData<ResponseProductDTO.Product> = _product

    init {
        getProduct()
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
}
