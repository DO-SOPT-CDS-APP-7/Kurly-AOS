package com.example.chicoryaos.ui.bookmark

import androidx.annotation.DrawableRes

data class Bookmark(
    @DrawableRes val productImage: Int,
    val productTitle: String,
    val productPrice: Int,
)
