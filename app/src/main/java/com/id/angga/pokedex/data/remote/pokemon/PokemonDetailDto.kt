package com.id.angga.pokedex.data.remote.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonDetailDto(
    @SerializedName("types")
    var types : List<PokemonTypeDto> = emptyList()
)