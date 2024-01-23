package com.id.angga.pokedex.domain.pokemon

import android.os.Parcelable
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonTypeColour
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonTypeItem(
    var slot : Int,
    var type: PokemonType,
) : Parcelable