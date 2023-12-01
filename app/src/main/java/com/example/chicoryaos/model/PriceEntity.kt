package com.example.chicoryaos.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceEntity(
    val id: Int,
    val name: String,
    var count: Int,
    var price: Int,
) : Parcelable
