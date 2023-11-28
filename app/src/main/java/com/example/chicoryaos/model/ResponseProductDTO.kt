package com.example.chicoryaos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseProductDTO(
    @SerialName("status")
    val status: String = "",
    @SerialName("message")
    val message: String = "",
    @SerialName("data")
    val data: Product
) {
    @Serializable
    data class Product(
        @SerialName("deliveryType")
        val deliveryType: String = "",
        @SerialName("productName")
        val productName: String = "'",
        @SerialName("discountRate")
        val discountRate: Int = 0,
        @SerialName("originalPrice")
        val originalPrice: Int = 0,
        @SerialName("discountedPrice")
        val discountedPrice: String = "",
        @SerialName("sellerName")
        val sellerName: String = "",
        @SerialName("imageURL")
        val imageURL: String = ""
    )
}
