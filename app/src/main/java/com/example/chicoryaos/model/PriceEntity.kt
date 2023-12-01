package com.example.chicoryaos.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceEntity(
    var id: Int,
    var count: Int,
    var deliveryType: String,
    var productName: String,
    var originalPrice: Int,
    var discountedPrice: Int,
    var imageUrl: String?,
) : Parcelable
