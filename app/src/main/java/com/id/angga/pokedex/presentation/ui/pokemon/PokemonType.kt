package com.id.angga.pokedex.presentation.ui.pokemon

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.id.angga.pokedex.domain.pokemon.PokemonTypeItem
import com.id.angga.pokedex.domain.util.replaceFirstChar
import com.id.angga.pokedex.presentation.ui.pokemon.list.CircularText

@Composable
fun ListTypePokemon(list: List<PokemonTypeItem>) {
    LazyRow(
        content = {
            items(list) { item ->
                TypeItem(pokemonTypeItem = item)
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    )
}


@Composable
fun TypeItem(pokemonTypeItem: PokemonTypeItem) {
    CircularText(
        text = pokemonTypeItem.type.name.replaceFirstChar(),
        background = PokemonTypeColour.fromType(pokemonTypeItem.type.name).typeColor
    )
}