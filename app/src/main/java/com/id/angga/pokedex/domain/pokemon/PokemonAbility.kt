package com.id.angga.pokedex.domain.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAbility (
    var ability: Ability,
    var isHidden : Boolean = false
) : Parcelable