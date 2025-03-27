package com.droidcon.flavorshub.model

import com.droidcon.flavorshub.R

enum class FavoriteState(
    val iconRes: Int,
    val contentDescriptionRes: Int
) {
    FAVORITE(
        iconRes = R.drawable.ic_baseline_favorite_24,
        contentDescriptionRes = R.string.remove_from_favorites_icon
    ),
    NOT_FAVORITE(
        iconRes = R.drawable.ic_baseline_favorite_border_24,
        contentDescriptionRes = R.string.add_to_favorites_icon
    )
}