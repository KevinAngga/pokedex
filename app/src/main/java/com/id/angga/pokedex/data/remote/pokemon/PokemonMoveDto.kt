package com.id.angga.pokedex.data.remote.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonMoveDto(
    @SerializedName("move")
    var move: MoveDto,
)
