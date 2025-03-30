package com.droidcon.flavorshub.ui.model

import androidx.annotation.DrawableRes
import com.droidcon.flavorshub.ui.R

enum class FavoriteState(
    @DrawableRes val iconRes: Int,
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