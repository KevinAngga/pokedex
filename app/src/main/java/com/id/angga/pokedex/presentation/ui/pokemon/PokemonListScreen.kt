package com.id.angga.pokedex.presentation.ui.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.id.angga.pokedex.R
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.pokemon.PokemonTypeItem
import com.id.angga.pokedex.domain.util.formatNumberWithLeadingZeros
import com.id.angga.pokedex.domain.util.replaceFirstChar
import com.id.angga.pokedex.presentation.ui.theme.NormalTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.PoisonTypeBackground


@Composable
fun PokemonListScreen(pokemons : List<PokemonDetailResponse>) {
    Column(
        modifier = Modifier
    ) {
        LazyColumn(
            content = {
                items(pokemons) { pokemon ->
                    PokemonListItem(pokemon)
                }
            }
        )
    }
}


@Composable
fun PokemonListItem(pokemon : PokemonDetailResponse) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topEnd = 48.dp, bottomEnd = 48.dp))
                .background(PokemonTypeColour.fromType(pokemon.types[0].type.name).background),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(
                    text = pokemon.id.toString().formatNumberWithLeadingZeros(),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))

                CircularImage(
                    imageUrl = pokemon.getSpriteImageUrl(),
                    contentDescription = pokemon.name
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .padding(4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = pokemon.name.replaceFirstChar(),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                ListTypePokemon(list = pokemon.types)
            }

        }
    }
}

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

@Composable
fun CircularText(text: String,
                 style : TextStyle = TextStyle(),
                 background: Color = NormalTypeBackground) {
    Box(
        modifier = Modifier
            .width(80.dp)
            .height(24.dp)
            .clip(RoundedCornerShape(48.dp))
            .background(color = background)
            .padding(top = 2.dp, bottom = 2.dp, start = 16.dp, end = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = style,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}

@Composable
fun CircularImage(imageUrl: String, contentDescription: String) {
    Box(
        modifier = Modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(color = Color.White)
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(
                context = LocalContext.current
            ).data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            placeholder = painterResource(id = R.drawable.ic_pokeball),
            error = painterResource(id = R.drawable.ic_pokeball),
            modifier = Modifier
                .size(45.dp),
            contentScale = ContentScale.FillWidth
        )
    }
}