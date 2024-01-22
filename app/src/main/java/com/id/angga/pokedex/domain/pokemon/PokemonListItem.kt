package com.id.angga.pokedex.domain.pokemon

data class PokemonListItem(
    val name: String,
    val url: String
) {
    //used for detail later
    fun getImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/other/official-artwork/$index.png"
    }
}