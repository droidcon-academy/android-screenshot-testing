package com.droidcon.flavorshub.model.screens

import com.droidcon.flavorshub.model.Type

data class MainScreenRecipeItem(
    val id: Int,
    val name: String,
    val cookingTimeInMin: Int,
    val shortDescription: String,
    val type: Type,
    val imageUrl: String,
    val isFavorite: Boolean
)