package com.id.angga.pokedex.data.remote.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonAbilityDto(
    @SerializedName("ability")
    var ability: AbilityDto,
    @SerializedName("is_hidden")
    var isHidden : Boolean = false
)
