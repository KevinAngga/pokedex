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
