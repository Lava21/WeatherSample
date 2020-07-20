package com.mas.sampleweather.untils

import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(): String? {
    val locale = Locale("id")
    val inputDate = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", locale)
    val outputDate = SimpleDateFormat("EEEE, dd MMMM yyyy", locale)
    val date = inputDate.parse(this)
    return outputDate.format(date)
}

fun String.formatDateToHour(): String? {
    val locale = Locale("id")
    val inputDate = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", locale)
    val outputDate = SimpleDateFormat("hh a", locale)
    val date = inputDate.parse(this)
    return outputDate.format(date)
}