package com.droidcon.flavorshub.viewmodels

import androidx.lifecycle.ViewModel
import com.droidcon.flavorshub.model.screens.RecipeDetailsItem

class RecipeDetailsScreenViewModel: ViewModel() {

    private val recipesRepo = RecipesRepo()

    fun fetchedRecipeById(recipeId: Int): RecipeDetailsItem {
        val recipe = recipesRepo.fetchRecipeById(recipeId).recipe
        return RecipeDetailsItem(
            id = recipe.id,
            name = recipe.name,
            cookingTimeInMin = recipe.cookingTimeInMin,
            type = recipe.type,
            imageUrl = recipe.imageUrl,
            ingredients = recipe.ingredients,
            instructions = recipe.instructions
        )
    }
}