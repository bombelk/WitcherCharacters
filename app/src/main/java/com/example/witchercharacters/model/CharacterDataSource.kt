package com.example.witchercharacters.model

import com.example.witchercharacters.R


object CharactersRepositories{
    val characters = listOf(
        Character(
            nameRes = R.string.ciri_name,
            imagerRes = R.drawable.ciri_drawable,
            descriptionRes = R.string.ciri_description
        ),
        Character(
            nameRes = R.string.geralt_name,
            imagerRes = R.drawable.w3_ss_geralt_dziennik,
            descriptionRes = R.string.geralt_description
        ),Character(
            nameRes = R.string.radowid_name,
            imagerRes = R.drawable.w3_ss_radowid,
            descriptionRes = R.string.radowid_description
        ),
        Character(
            nameRes = R.string.vilgefortz_name,
            imagerRes = R.drawable.g_ss_vilgefortz_renegat,
            descriptionRes = R.string.vilgefortz_description
        ),

    )
}