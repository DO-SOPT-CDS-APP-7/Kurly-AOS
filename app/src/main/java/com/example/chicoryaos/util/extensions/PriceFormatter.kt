package com.example.chicoryaos.util.extensions

import java.text.DecimalFormat

class PriceFormatter {
    companion object {
        fun formatPrice(price: Int): String {
            return DecimalFormat("#,###").format(price)
        }
    }
}
