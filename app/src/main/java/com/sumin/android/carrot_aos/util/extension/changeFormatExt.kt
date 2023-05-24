package com.sumin.android.carrot_aos.util.extension

import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun changeTimeFormat(inputTime: String): String {
    val originFormatter = DateTimeFormatter.ofPattern("yyyy. M. d. a h:mm:ss", Locale.KOREA)
    val changeFormatter = DateTimeFormatter.ofPattern("a h:mm", Locale.KOREA)
    val originTimeFormat = LocalDateTime.parse(inputTime, originFormatter)

    return changeFormatter.format(originTimeFormat)
}

fun changePriceFormat(inputPrice: Int): String {
    val formatter = DecimalFormat("#,###")

    return formatter.format(inputPrice)
}