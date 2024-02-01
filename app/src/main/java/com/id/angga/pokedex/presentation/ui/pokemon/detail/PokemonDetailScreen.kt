package com.id.angga.pokedex.presentation.ui.pokemon.detail

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.id.angga.pokedex.R
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.pokemon.PokemonType
import com.id.angga.pokedex.domain.pokemon.PokemonTypeItem
import com.id.angga.pokedex.domain.pokemon.TabMenuItem
import com.id.angga.pokedex.domain.util.formatNumberWithLeadingZeros
import com.id.angga.pokedex.domain.util.replaceFirstChar
import com.id.angga.pokedex.presentation.ui.pokemon.ListTypePokemon
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonAboutScreen
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonMovesScreen
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonStatScreen
import com.id.angga.pokedex.presentation.ui.pokemon.PokemonTypeColour
import com.id.angga.pokedex.presentation.ui.theme.openSansFamily

var tabItem = listOf(
    TabMenuItem(
        title = "About"
    ),

    TabMenuItem(
        title = "Base Stat"
    ),

    TabMenuItem(
        title = "Moves"
    )
)


@Preview
@Composable
fun DetailPreview() {
    PokemonDetailScreen(
        navigateUp = {},
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    pokemonDetailResponse: PokemonDetailResponse,
    navigateUp : () -> Unit
) {
    val pokemon = pokemonDetailResponse

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

   Scaffold (
       modifier = Modifier
           .fillMaxSize(),
       topBar = {
           TopAppBar(
               title = {},
               colors = TopAppBarDefaults.topAppBarColors(
                   containerColor = PokemonTypeColour.fromType(pokemon.types[0].type.name).background,
                   actionIconContentColor = Color.White,
                   navigationIconContentColor = Color.White
               ),
               navigationIcon = {
                   IconButton(onClick = navigateUp) {
                       Icon(
                           painter = painterResource(id = R.drawable.ic_arrow_back),
                           contentDescription = null,
                       )
                   }
               }
           )
       }
   ) { paddingValues  ->
       Box(
           modifier = Modifier
               .padding(paddingValues)
       ) {
           Column(
               modifier = Modifier
                   .background(PokemonTypeColour.fromType(pokemon.types[0].type.name).background)
           ) {
               Box(
                   modifier = Modifier
                       .weight(1f)
                       .padding(horizontal = 16.dp)
               ) {
                   Column {
                       Row (
                           modifier = Modifier.fillMaxWidth(),
                           horizontalArrangement = Arrangement.SpaceBetween,
                           verticalAlignment = Alignment.Bottom
                       ) {
                           Text(
                               text = pokemon.name.replaceFirstChar(),
                               fontSize = 36.sp,
                               color = Color.White,
                               fontFamily = openSansFamily,
                               fontWeight = FontWeight.Bold
                           )

                           Text(
                               text = pokemon.id.toString().formatNumberWithLeadingZeros(),
                               fontSize = 16.sp,
                               color = Color.White,
                               fontFamily = openSansFamily,
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
                       Spacer(modifier = Modifier.height(16.dp))
                       TabRow(
                           modifier = Modifier.padding(horizontal = 16.dp),
                           selectedTabIndex = selectedTabIndex,
                           indicator = {
                               Box(
                                   Modifier
                                       .tabIndicatorOffset(it[selectedTabIndex])
                                       .height(2.dp)
                                       .border(2.dp, Color.Blue)
                               )
                           }
                       ) {
                           tabItem.forEachIndexed { index, tabMenuItem ->
                               Tab(
                                   modifier = Modifier
                                       .background(Color.White)
                                   ,
                                   selected = index == selectedTabIndex,
                                   onClick = { selectedTabIndex = index },
                                   selectedContentColor = Color.Black,
                                   unselectedContentColor = Color.Gray,
                                   text = {
                                       Text(
                                           text = tabMenuItem.title,
                                           fontFamily = openSansFamily,
                                           fontWeight = FontWeight.SemiBold
                                       )
                                   }
                               )
                           }
                       }

                       when(selectedTabIndex) {
                           0 -> PokemonAboutScreen(
                               height = pokemon.height,
                               weight = pokemon.weight,
                               abilities = pokemon.abilities
                           )
                           1 -> PokemonStatScreen(pokemon.stat)
                           2 -> PokemonMovesScreen(pokemon.moves)
                       }
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
                   .size(240.dp)
                   .offset(0.dp, (-70).dp)
                   .align(Alignment.Center),
               contentDescription = "")
       }
   }
}