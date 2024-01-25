package com.id.angga.pokedex.domain.util

fun String.formatNumberWithLeadingZeros(): String {
    return when (this.length) {
        1 -> "#00$this"
        2 -> "#0$this"
        else -> "#$this"
    }
}

fun String.replaceFirstChar() : String {
    return this.replaceFirstChar { it.uppercase() }
}

fun Int.getWeightString(): String = String.format("%.1f KG", this.toFloat() / 10)
fun Int.getHeightString(): String = String.format("%.1f M", this.toFloat() / 10)
