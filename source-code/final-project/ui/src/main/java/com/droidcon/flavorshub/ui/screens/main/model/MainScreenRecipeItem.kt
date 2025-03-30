package com.droidcon.flavorshub.ui.screens.main.model

import com.droidcon.flavorshub.ui.model.FavoriteState
import com.droidcon.flavorshub.ui.model.Type

data class MainScreenRecipeItem(
    val id: Int,
    val name: String,
    val cookingTimeInMin: Int,
    val shortDescription: String,
    val type: Type,
    val imageUrl: String,
    val isFavorite: FavoriteState
)