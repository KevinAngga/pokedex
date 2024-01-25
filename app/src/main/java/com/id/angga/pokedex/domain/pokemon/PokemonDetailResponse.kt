package com.id.angga.pokedex.domain.pokemon

import android.os.Parcelable
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonTypeColour
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonDetailResponse (
    var id : Int = 0,
    var name : String = "",
    var weight : Int = 0,
    var height : Int = 0,
    var types : List<PokemonTypeItem> = emptyList(),
    var stat: List<PokemonStat> = emptyList(),
    var abilities: List<PokemonAbility> = emptyList(),
    var moves : List<PokemonMove> = emptyList()
) : Parcelable {
    fun getSpriteImageUrl(): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/$id.png"
    }

    fun getImageUrl(): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/other/official-artwork/$id.png"
    }
}