package com.droidcon.flavorshub.model.screens

import com.droidcon.flavorshub.model.Type

data class RecipeDetailsItem(
    val id: Int,
    val name: String,
    val cookingTimeInMin: Int,
    val type: Type,
    val imageUrl: String,
    val ingredients: List<String>,
    val instructions: List<String>
)