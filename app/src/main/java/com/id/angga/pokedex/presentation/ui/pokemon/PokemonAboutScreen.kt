package com.id.angga.pokedex.presentation.ui.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.id.angga.pokedex.domain.pokemon.Ability
import com.id.angga.pokedex.domain.pokemon.PokemonAbility
import com.id.angga.pokedex.domain.util.getHeightString
import com.id.angga.pokedex.domain.util.getWeightString
import com.id.angga.pokedex.domain.util.replaceFirstChar
import com.id.angga.pokedex.presentation.ui.theme.fontColorBlackInActive
import com.id.angga.pokedex.presentation.ui.theme.openSansFamily


@Preview
@Composable
fun AboutPreview() {
    PokemonAboutScreen(
        height = 7,
        weight = 69,
        abilities = listOf(
            PokemonAbility(
                ability = Ability(
                    name = "overgrow"
                )
            )
        )
    )
}

@Composable
fun PokemonAboutScreen(
    height: Int,
    weight: Int,
    abilities: List<PokemonAbility>,
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        PokemonInfo(height = height, weight = weight)

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Pokemon Ability",
            fontWeight = FontWeight.Bold,
            fontFamily = openSansFamily
        )

        LazyColumn(
            content = {
                items(abilities) { ability ->
                    PokemonAbilityItem(ability = ability)
                }
            }
        )
    }
}

@Composable
fun PokemonAbilityItem(ability: PokemonAbility) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = ability.ability.name.replaceFirstChar(),
            fontWeight = FontWeight.Medium,
            fontFamily = openSansFamily
        )
        Spacer(modifier = Modifier.width(16.dp))
        if (ability.isHidden) {
            CircularText(
                text = "Hidden",
                background = PokemonTypeColour.Normal.typeColor
            )
        }
    }
}


@Composable
fun PokemonInfo(height: Int, weight: Int) {
    Column {
        Card(
            modifier = Modifier,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Height",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = fontColorBlackInActive,
                        fontFamily = openSansFamily
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = height.getHeightString(),
                        fontFamily = openSansFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Weight",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = fontColorBlackInActive,
                        fontFamily = openSansFamily
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = weight.getWeightString(),
                        fontFamily = openSansFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}