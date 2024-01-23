package com.id.angga.pokedex.data.remote.pokemon

import com.google.gson.annotations.SerializedName

data class StatDto(
    @SerializedName("name")
    var name : String = "",
    @SerializedName("")
    var url : String = ""
)
