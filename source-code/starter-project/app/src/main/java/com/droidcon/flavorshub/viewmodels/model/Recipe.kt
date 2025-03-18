package com.droidcon.flavorshub.viewmodels.model

data class Recipe(
    val id: Int,
    val name: String,
    val cookingTimeInMin: Int,
    val shortDescription: String,
    val type: Type,
    val imageUrl: String,
)