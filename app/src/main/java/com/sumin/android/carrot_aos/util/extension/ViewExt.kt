package com.sumin.android.carrot_aos.util.extension

import android.content.Context
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

// 화면 전체
fun View.showSnackbar(
    message: String,
    duration: Int = Snackbar.LENGTH_SHORT,
) {
    Snackbar
        .make(this, message, duration)
        .show()
}

// 해당 뷰 위로 올릴 때
fun View.showSnackbar(
    message: String,
    anchor: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
) {
    Snackbar
        .make(this, message, duration)
        .setAnchorView(anchor)
        .show()
}

fun View.hideKeyboard() {
    try {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(windowToken, 0)
    } catch (e: Exception) {
        Log.e("error", e.message.toString())
    }
}

fun TextView.underLine() {
    val content = SpannableString(this.text.toString())
    content.setSpan(UnderlineSpan(), 0, content.length, 0)
    this.text = content
}