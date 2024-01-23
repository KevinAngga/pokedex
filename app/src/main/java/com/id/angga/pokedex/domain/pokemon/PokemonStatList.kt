package com.id.angga.pokedex.domain.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class PokemonStatList(
    var stats : List<PokemonStat> = emptyList()
) : Parcelable
