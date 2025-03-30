package com.droidcon.flavorshub.ui.model

data class Recipe(
    val id: Int,
    val name: String,
    val cookingTimeInMin: Int,
    val shortDescription: String,
    val type: Type,
    val imageUrl: String,
    val ingredients: List<String>,
    val instructions: List<String>
)