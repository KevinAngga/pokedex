package com.id.angga.pokedex.presentation.ui.pokemon

import androidx.compose.ui.graphics.Color
import com.id.angga.pokedex.presentation.ui.theme.BugType
import com.id.angga.pokedex.presentation.ui.theme.BugTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.DarkType
import com.id.angga.pokedex.presentation.ui.theme.DarkTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.DragonType
import com.id.angga.pokedex.presentation.ui.theme.DragonTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.ElectricType
import com.id.angga.pokedex.presentation.ui.theme.ElectricTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.FairyType
import com.id.angga.pokedex.presentation.ui.theme.FairyTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.FightType
import com.id.angga.pokedex.presentation.ui.theme.FightTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.FireType
import com.id.angga.pokedex.presentation.ui.theme.FireTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.FlyingType
import com.id.angga.pokedex.presentation.ui.theme.FlyingTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.GhostType
import com.id.angga.pokedex.presentation.ui.theme.GhostTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.GrassType
import com.id.angga.pokedex.presentation.ui.theme.GrassTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.GroundType
import com.id.angga.pokedex.presentation.ui.theme.GroundTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.IceType
import com.id.angga.pokedex.presentation.ui.theme.IceTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.NormalType
import com.id.angga.pokedex.presentation.ui.theme.NormalTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.PoisonType
import com.id.angga.pokedex.presentation.ui.theme.PoisonTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.PsychicType
import com.id.angga.pokedex.presentation.ui.theme.PsychicTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.RockType
import com.id.angga.pokedex.presentation.ui.theme.RockTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.SteelType
import com.id.angga.pokedex.presentation.ui.theme.SteelTypeBackground
import com.id.angga.pokedex.presentation.ui.theme.WaterType
import com.id.angga.pokedex.presentation.ui.theme.WaterTypeBackground

sealed class PokemonTypeColour(
    var background: Color,
    var typeColor: Color,
) {

    object Normal : PokemonTypeColour(
        background = NormalTypeBackground,
        typeColor = NormalType
    )

    object Fire : PokemonTypeColour(
        background = FireTypeBackground,
        typeColor = FireType
    )

    object Fight : PokemonTypeColour(
        background = FightTypeBackground,
        typeColor = FightType
    )

    object Water : PokemonTypeColour(
        background = WaterTypeBackground,
        typeColor = WaterType
    )

    object Flying : PokemonTypeColour(
        background = FlyingTypeBackground,
        typeColor = FlyingType
    )

    object Grass : PokemonTypeColour(
        background = GrassTypeBackground,
        typeColor = GrassType
    )

    object Poison : PokemonTypeColour(
        background = PoisonTypeBackground,
        typeColor = PoisonType
    )

    object Electric : PokemonTypeColour(
        background = ElectricTypeBackground,
        typeColor = ElectricType
    )

    object Ground : PokemonTypeColour(
        background = GroundTypeBackground,
        typeColor = GroundType
    )

    object Psychic : PokemonTypeColour(
        background = PsychicTypeBackground,
        typeColor = PsychicType
    )

    object Rock : PokemonTypeColour(
        background = RockTypeBackground,
        typeColor = RockType
    )

    object Ice : PokemonTypeColour(
        background = IceTypeBackground,
        typeColor = IceType
    )

    object Bug : PokemonTypeColour(
        background = BugTypeBackground,
        typeColor = BugType
    )

    object Dragon : PokemonTypeColour(
        background = DragonTypeBackground,
        typeColor = DragonType
    )

    object Ghost : PokemonTypeColour(
        background = GhostTypeBackground,
        typeColor = GhostType
    )

    object Dark : PokemonTypeColour(
        background = DarkTypeBackground,
        typeColor = DarkType
    )

    object Steel : PokemonTypeColour(
        background = SteelTypeBackground,
        typeColor = SteelType
    )

    object Fairy : PokemonTypeColour(
        background = FairyTypeBackground,
        typeColor = FairyType
    )

    companion object {
        fun fromType(type: String): PokemonTypeColour {
            return when (type.lowercase()) {
                "normal" -> Normal
                "fire" -> Fire
                "fight" -> Fight
                "water" -> Water
                "flying" -> Flying
                "grass" -> Grass
                "poison" -> Poison
                "electric" -> Electric
                "ground" -> Ground
                "psychic" -> Psychic
                "rock" -> Rock
                "ice" -> Ice
                "bug" -> Bug
                "dragon" -> Dragon
                "ghost" -> Ghost
                "dark" -> Dark
                "steel" -> Steel
                "fairy" -> Fairy
                else -> Normal
            }
        }
    }
}