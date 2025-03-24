package com.droidcon.flavorshub.viewmodels

import androidx.lifecycle.ViewModel
import com.droidcon.flavorshub.model.screens.RecipeDetailsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsScreenViewModel @Inject constructor(
    private val recipesRepo: RecipesRepo
) : ViewModel() {

    fun fetchRecipeInCurrentLocaleById(recipeId: Int): RecipeDetailsItem {
        val recipe = recipesRepo.fetchRecipeInCurrentLocaleById(recipeId).recipe
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