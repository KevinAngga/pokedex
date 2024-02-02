package com.id.angga.pokedex.domain.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonListItem(
    val name: String = "'",
    val url: String = ""
) : Parcelable {
    fun getPokemonId() : String {
        return  url.split("/".toRegex()).dropLast(1).last()
    }
    fun getSpriteImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/$index.png"
    }
}