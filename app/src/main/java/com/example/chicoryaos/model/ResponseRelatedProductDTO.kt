package com.example.chicoryaos.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseRelatedProductDTO(
    val data: List<Data>,
    val message: String,
    val status: String,
) {
    @Serializable
    data class Data(
        val deliveryType: String,
        val imageURL: String,
        val originalPrice: Int,
        val productName: String,
    )
}
