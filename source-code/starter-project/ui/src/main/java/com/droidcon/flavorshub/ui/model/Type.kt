package com.droidcon.flavorshub.ui.model

import com.droidcon.flavorshub.ui.R

enum class Type(
    val icon: Int,
    val text: Int,
) {
    MEAT(
        icon = R.drawable.ic_meat_50,
        text = R.string.filter_meat
    ),
    FISH(
        icon = R.drawable.ic_fish_50,
        text = R.string.filter_fish
    ),
    VEGAN(
        icon = R.drawable.ic_vegan_50,
        text = R.string.filter_vegan
    )
}