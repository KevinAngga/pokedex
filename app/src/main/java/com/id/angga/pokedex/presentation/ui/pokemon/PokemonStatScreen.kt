package com.id.angga.pokedex.presentation.ui.pokemon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.id.angga.pokedex.domain.pokemon.PokemonStat
import com.id.angga.pokedex.domain.pokemon.Stat
import com.id.angga.pokedex.domain.util.replaceFirstChar
import com.id.angga.pokedex.presentation.ui.theme.openSansFamily

@Preview
@Composable
fun PokemonStatPreview() {
    PokemonStatScreen(
        stats = arrayListOf(
            PokemonStat(
                baseStat = 45,
                stat = Stat(
                    "Hp", ""
                )
            )
        )
    )
}

@Composable
fun PokemonStatScreen(stats: List<PokemonStat>) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        PokemonStatList(stats = stats)
    }
}


@Composable
fun PokemonStatList(stats: List<PokemonStat>) {
    LazyColumn(
        content = {
            items(stats) { stat ->
                PokemonStatItem(stat = stat)
            }
        }
    )
}

@Composable
fun PokemonStatItem(stat: PokemonStat) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stat.stat.name.replaceFirstChar(),
            fontFamily = openSansFamily,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = stat.baseStat.toString(),
            fontFamily = openSansFamily,
            fontWeight = FontWeight.SemiBold
        )
    }
    Spacer(modifier = Modifier.height(12.dp))
}