package com.example.chicoryaos.data

import com.example.chicoryaos.model.ResponseProductDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthService {
    @GET("product/{productId}")
    fun getProduct(
        @Path("productId") productId: String,
    ): Call<ResponseProductDTO>
}