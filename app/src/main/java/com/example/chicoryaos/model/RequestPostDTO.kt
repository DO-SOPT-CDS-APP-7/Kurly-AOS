package com.example.chicoryaos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestPostDTO(
    @SerialName("productId")
    val productId: String,
    @SerialName("count")
    val count: String,
)
