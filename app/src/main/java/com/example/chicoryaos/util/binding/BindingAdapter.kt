package com.example.chicoryaos.util.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.chicoryaos.util.extensions.PriceFormatter

object BindingAdapter {
    @BindingAdapter("setImage")
    @JvmStatic
    fun ImageView.setImage(imgUrl: String?) {
        this.let {
            Glide.with(context)
                .load(imgUrl)
                .into(this)
        }
    }

    @BindingAdapter("formattedPrice")
    @JvmStatic
    fun TextView.setFormattedPrice(amount: Int) {
        this.let {
            it.text = "${PriceFormatter.formatPrice(amount)}원"
        }
    }
}
