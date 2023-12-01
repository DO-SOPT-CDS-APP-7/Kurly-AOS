package com.example.chicoryaos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRelatedDTO(
    @SerialName("data")
    val data: List<Data>,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: String,
) {
    @Serializable
    data class Data(
        @SerialName("deliveryType")
        val deliveryType: String,
        @SerialName("productName")
        val productName: String,
        @SerialName("originalPrice")
        val originalPrice: Int,
        @SerialName("imageURL")
        val imageURL: String,
    )
}