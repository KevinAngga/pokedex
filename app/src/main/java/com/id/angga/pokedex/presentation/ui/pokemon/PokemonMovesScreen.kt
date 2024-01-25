package com.id.angga.pokedex.presentation.ui.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.id.angga.pokedex.domain.pokemon.Move
import com.id.angga.pokedex.domain.pokemon.PokemonMove
import com.id.angga.pokedex.domain.util.replaceFirstChar
import com.id.angga.pokedex.presentation.ui.theme.openSansFamily

@Preview
@Composable
fun PokemonMovePreview() {
    PokemonMovesScreen(
        moves = listOf(
            PokemonMove(
                move = Move(
                    name = "mega-punch"
                )
            ),

            PokemonMove(
                move = Move(
                    name = "mega-kick"
                )
            ),

            PokemonMove(
                move = Move(
                    name = "fire-punch"
                )
            ),
        )
    )
}

@Composable
fun PokemonMovesScreen(moves: List<PokemonMove>) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(moves) { pokemonMove ->
            PokemonMoveItem(move = pokemonMove)
        }
    }
}

@Composable
fun PokemonMoveItem(move: PokemonMove) {
    Column(
        modifier = Modifier.padding(4.dp)
    ) {
        Card (
            Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = move.move.name.replaceFirstChar(),
                    fontWeight = FontWeight.Light,
                    fontFamily = openSansFamily
                )
            }
        }
    }
}