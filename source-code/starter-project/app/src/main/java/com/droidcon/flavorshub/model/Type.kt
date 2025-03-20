package com.droidcon.flavorshub.model

import com.droidcon.flavorshub.R

enum class Type(
    val icon: Int,
    val text: String,
) {
    MEAT(
        icon = R.drawable.ic_meat_50,
        text = "Meat"
    ),
    FISH(
        icon = R.drawable.ic_fish_50,
        text = "Fish"
    ),
    VEGAN(
        icon = R.drawable.ic_vegan_50,
        text = "Vegan"
    )
}