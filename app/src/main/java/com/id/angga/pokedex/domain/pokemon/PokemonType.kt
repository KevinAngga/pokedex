package com.id.angga.pokedex.domain.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonType(
    var name : String
) : Parcelable
