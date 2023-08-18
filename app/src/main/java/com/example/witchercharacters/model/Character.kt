package com.example.witchercharacters.model


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Character(
    @StringRes val nameRes: Int,
    @DrawableRes val imagerRes: Int,
    @StringRes val descriptionRes : Int,
)