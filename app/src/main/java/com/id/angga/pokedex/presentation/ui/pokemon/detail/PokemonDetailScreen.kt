package com.id.angga.pokedex.presentation.ui.pokemon.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.id.angga.pokedex.R
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.pokemon.PokemonType
import com.id.angga.pokedex.domain.pokemon.PokemonTypeItem
import com.id.angga.pokedex.domain.util.formatNumberWithLeadingZeros
import com.id.angga.pokedex.domain.util.replaceFirstChar
import com.id.angga.pokedex.presentation.ui.pokemon.ListTypePokemon
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonTypeColour


@Preview
@Composable
fun DetailPreview() {
    PokemonDetailScreen(
        pokemonDetailResponse = PokemonDetailResponse(
            id = 1,
            name = "bulbasaur",
            weight = 69,
            types = listOf(
                PokemonTypeItem(
                    slot = 1,
                    type = PokemonType(
                        name = "grass"
                    )
                ),

                PokemonTypeItem(
                    slot = 2,
                    type = PokemonType(
                        name = "poison"
                    )
                )
            )
        )
    )
}


@Composable
fun PokemonDetailScreen(
    pokemonDetailResponse: PokemonDetailResponse
) {
    val pokemon = pokemonDetailResponse

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PokemonTypeColour.fromType(pokemon.types[0].type.name).background)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Column {
                    Spacer(modifier = Modifier.height(30.dp))
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = pokemon.name.replaceFirstChar(),
                            fontSize = 36.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = pokemon.id.toString().formatNumberWithLeadingZeros(),
                            fontSize = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ListTypePokemon(list = pokemon.types)
                    }
                }
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(text = "asdasd")
                }
            }
        }

        AsyncImage(
            model = ImageRequest.Builder(
                context = LocalContext.current
            ).data(pokemon.getImageUrl())
                .crossfade(true
                ).build()
            ,
            modifier = Modifier
                .size(160.dp)
                .offset(0.dp, (-50).dp)
                .align(Alignment.Center),
            contentDescription = "")
    }
}