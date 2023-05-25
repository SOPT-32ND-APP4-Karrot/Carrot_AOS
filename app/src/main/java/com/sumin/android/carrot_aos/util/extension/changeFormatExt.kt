package com.sumin.android.carrot_aos.util.extension

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun changeTimeFormat(inputTime: String): String {
    val originFormatter = DateTimeFormatter.ofPattern("yyyy. M. d. a h:mm:ss", Locale.KOREA)
    val changeFormatter = DateTimeFormatter.ofPattern("a h:mm", Locale.KOREA)
    val originTimeFormat = LocalDateTime.parse(inputTime, originFormatter)

    return changeFormatter.format(originTimeFormat)
}

fun newTimeFormat(): String {
    val timeFormatter = SimpleDateFormat("yyyy. M. d. a h:mm:ss", Locale.KOREA)

    return timeFormatter.format(System.currentTimeMillis())
}

fun changePriceFormat(inputPrice: Int): String {
    val formatter = DecimalFormat("#,###")

    return formatter.format(inputPrice)
}