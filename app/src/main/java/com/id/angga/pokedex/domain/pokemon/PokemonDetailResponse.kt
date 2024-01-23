package com.id.angga.pokedex.domain.pokemon

import com.id.angga.pokedex.presentation.ui.pokemon.PokemonTypeColour


data class PokemonDetailResponse (
    var id : Int = 0,
    var name : String = "",
    var weight : Int = 0,
    var types : List<PokemonTypeItem> = emptyList(),
    var stat: List<PokemonStat> = emptyList(),
    var abilities: List<PokemonAbility> = emptyList()
) {
    fun getSpriteImageUrl(): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/$id.png"
    }
}