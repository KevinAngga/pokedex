package com.id.angga.pokedex.data.remote.pokemon

import com.google.gson.annotations.SerializedName

data class MoveDto(
    @SerializedName("name")
    var name : String = ""
)
