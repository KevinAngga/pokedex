package com.id.angga.pokedex.presentation.ui.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.id.angga.pokedex.R
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.util.formatNumberWithLeadingZeros
import com.id.angga.pokedex.domain.util.replaceFirstChar
import com.id.angga.pokedex.presentation.ui.navigation.Screen
import com.id.angga.pokedex.presentation.ui.pokemon.detail.DetailViewModel
import com.id.angga.pokedex.presentation.ui.theme.NormalTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.openSansFamily


@Composable
fun PokemonListScreen(
    pokemonViewModel: PokemonViewModel,
    navController: NavController,
    detailViewModel: DetailViewModel
) {

    Column(
        modifier = Modifier
            .statusBarsPadding()
    ) {
        var pokemons = pokemonViewModel.page.collectAsLazyPagingItems()
        LazyColumn(
            content = {
                items(pokemons.itemCount) { index ->
                    pokemons[index]?.let {
                        PokemonListItem(
                            detailViewModel,
                            it,
                            navController = navController
                        )
                    }
                }
            }
        )
    }
}


@Composable
fun PokemonListItem(
    detailViewModel: DetailViewModel,
    pokemon : PokemonDetailResponse,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                detailViewModel.addPokemon(pokemon)
                navController.navigate(Screen.DetailPage.route)
            }
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
                    color = Color.White,
                    fontFamily = openSansFamily,
                    fontWeight = FontWeight.SemiBold
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
                    fontFamily = openSansFamily,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                ListTypePokemon(list = pokemon.types)
            }

        }
    }
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
            color = Color.White,
            fontFamily = openSansFamily,
            fontWeight = FontWeight.Light
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