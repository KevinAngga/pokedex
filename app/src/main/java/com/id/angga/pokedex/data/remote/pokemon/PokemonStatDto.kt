package com.id.angga.pokedex.data.remote.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonStatDto(
    @SerializedName("base_stat")
    var baseStat: Int = 0,
    @SerializedName("stat")
    var stat : StatDto = StatDto()
)