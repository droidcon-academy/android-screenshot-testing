package com.droidcon.flavorshub.screens.recipedetails.viewmodel

import androidx.lifecycle.ViewModel
import com.droidcon.flavorshub.repositories.RecipesRepo
import com.droidcon.flavorshub.repositories.model.Recipe
import com.droidcon.flavorshub.ui.model.Type
import com.droidcon.flavorshub.ui.screens.recipedetails.model.RecipeDetailsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsScreenViewModel @Inject constructor(
    private val recipesRepo: RecipesRepo
) : ViewModel() {

    fun fetchRecipeInCurrentLocaleById(recipeId: Int): RecipeDetailsItem {
        val recipe = recipesRepo.fetchRecipeInCurrentLocaleById(recipeId).recipe
        return recipe.toRecipeDetailsItem()
    }

    private fun Recipe.toRecipeDetailsItem(): RecipeDetailsItem =
        RecipeDetailsItem(
            id = id,
            name = name,
            cookingTimeInMin = cookingTimeInMin,
            type = Type.valueOf(type.name),
            imageUrl = imageUrl,
            ingredients = ingredients,
            instructions = instructions
        )
}