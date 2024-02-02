package com.id.angga.pokedex.presentation.ui.pokemon.detail.stat

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.id.angga.pokedex.domain.pokemon.PokemonStat
import com.id.angga.pokedex.domain.pokemon.Stat
import com.id.angga.pokedex.domain.util.replaceFirstChar
import com.id.angga.pokedex.presentation.ui.theme.GrassTypeBackground
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
fun PokemonStatList(
    stats: List<PokemonStat>,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        stats.maxOf { it.baseStat }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        for(i in stats.indices) {
            val stat = stats[i]
            PokemonStatBar(
                statName = stat.stat.name,
                statValue = stat.baseStat,
                statMaxValue = maxBaseStat,
                statColor = GrassTypeBackground,
                animDelay = i * animDelayPerItem
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun PokemonStatBar(
    statName: String,
    statValue: Int,
    statMaxValue: Int,
    statColor: Color,
    height: Dp = 12.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercent = animateFloatAsState(
        targetValue = if(animationPlayed) {
            statValue / statMaxValue.toFloat()
        } else 0f,
        animationSpec = tween(
            animDuration,
            animDelay
        ), label = ""
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = statName.replaceFirstChar(),
                fontFamily = openSansFamily,
                fontSize = 12.sp
            )
        }

        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = statValue.toString(),
                fontFamily = openSansFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
        
        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier
                .weight(3f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height)
                    .clip(CircleShape)
                    .background(
                        if (isSystemInDarkTheme()) {
                            Color(0xFF505050)
                        } else {
                            Color.LightGray
                        }
                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(curPercent.value)
                        .clip(CircleShape)
                        .background(statColor)
                        .padding(horizontal = 8.dp)
                ) {

                }
            }
        }
    }
}
