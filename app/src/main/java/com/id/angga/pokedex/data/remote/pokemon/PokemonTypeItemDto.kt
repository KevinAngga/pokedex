package com.id.angga.pokedex.data.remote.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonTypeItemDto(
    @SerializedName("slot")
    var slot : Int = 0,
    @SerializedName("type")
    var typeDto: PokemonTypeDto
)
