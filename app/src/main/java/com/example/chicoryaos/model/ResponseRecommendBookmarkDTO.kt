package com.example.chicoryaos.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseRecommendBookmarkDTO(
    val data: List<Data>,
    val message: String,
    val status: String,
) {
    @Serializable
    data class Data(
        val deliveryType: String,
        val productName: String,
        val originalPrice: Int,
        val imageURL: String,
    )
}
