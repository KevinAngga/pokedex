package com.id.angga.pokedex.domain.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stat(
    var name : String = "",
    var url : String = ""
) : Parcelable
