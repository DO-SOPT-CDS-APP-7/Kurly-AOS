package com.example.chicoryaos.data

import com.example.chicoryaos.model.ResponseProductDTO
import com.example.chicoryaos.model.ResponseRecommendBookmarkDTO
import com.example.chicoryaos.model.ResponseRelatedBookmarkDTO
import com.example.chicoryaos.model.ResponseRelatedProductDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthService {
    @GET("product/{productId}")
    fun getProduct(@Path("productId") productId: Int): Call<ResponseProductDTO>

    @GET("/product/{productId}/related")
    suspend fun getRelatedProduct(
        @Path("productId") productId: Int,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Response<ResponseRelatedDTO>

    @POST("/cart")
    suspend fun postProduct(
        @Header("X-Auth-id") authId: Int,
        @Body request: RequestPostDTO,
    ): Response<ResponsePostDTO>

    @DELETE("/cart")
    suspend fun deletePostProduct(
        @Header("X-Auth-id") authId: Int,
    ): Response<Unit>

    @GET("/product/{productId}/recommend")
    suspend fun getRecommendBookmarkProduct(
        @Path("productId") productId: Int,
    ): Response<ResponseRelatedDTO>
}
