package com.id.angga.pokedex.presentation.ui.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.id.angga.pokedex.domain.pokemon.PokemonAbility

@Composable
fun PokemonAbilityScreen(abilities : List<PokemonAbility>) {
    Column {
        Text(text = abilities[0].isHidden.toString())
        Text(text = abilities[0].ability.name)

        Text(text = abilities[1].isHidden.toString())
        Text(text = abilities[1].ability.name)
    }
}