package com.id.angga.pokedex.data.remote.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonListItemDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
