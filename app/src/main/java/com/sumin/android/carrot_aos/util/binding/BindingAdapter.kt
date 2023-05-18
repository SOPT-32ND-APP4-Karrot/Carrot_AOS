package com.sumin.android.carrot_aos.util.binding

import android.graphics.Paint
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load

object BindingAdapter {
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(url: String?) {
        this.load(url)
    }
}