package com.droidcon.flavorshub.ui.screens.recipedetails.model

import com.droidcon.flavorshub.ui.model.Type

data class RecipeDetailsItem(
    val id: Int,
    val name: String,
    val cookingTimeInMin: Int,
    val type: Type,
    val imageUrl: String,
    val ingredients: List<String>,
    val instructions: List<String>
)