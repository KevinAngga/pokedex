package com.id.angga.pokedex.domain.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonStat(
    var baseStat: Int = 0,
    var stat : Stat = Stat()
) : Parcelable