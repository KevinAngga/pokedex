package com.id.angga.pokedex.data.remote.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponseDto(
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("name")
    var name : String = "",
    @SerializedName("weight")
    var weight : Int = 0,
    @SerializedName("types")
    var types : List<PokemonTypeItemDto> = emptyList()
)