package com.example.chicoryaos.util.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.decode.SvgDecoder
import coil.load
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

    // 중복시 아래 삭제 가능
    @BindingAdapter("setCoilImage")
    @JvmStatic
    fun ImageView.setCoilImage(imgUrl: String?) {
        this.let {
            it.load(imgUrl) {
                if (imgUrl?.endsWith(".svg") == true) {
                    decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
                }
                crossfade(true)
            }
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
