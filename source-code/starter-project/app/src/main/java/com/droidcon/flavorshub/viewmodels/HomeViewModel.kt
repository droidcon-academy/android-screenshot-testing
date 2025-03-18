package com.droidcon.flavorshub.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.droidcon.flavorshub.viewmodels.model.Recipe

class HomeViewModel : ViewModel() {
    // State for the UI
    data class RecipeUi(
        val recipe: Recipe,
        val isFavourite: Boolean
    )

    sealed class UiState {
        data class Success(val recipes: List<RecipeUi>) : UiState()
        // TODO - check which states are necessary
        // object Loading : UiState()
        // data class Error(val message: String) : UiState()
    }

    private val recipesRepo = RecipesRepo()
    private var fetchedRecipes: List<RecipeUi> = recipesRepo.fetchRecipes()

    var uiState by mutableStateOf<UiState>(UiState.Success(fetchedRecipes))
        private set

    fun toggleFavorite(recipeId: Int) {
        fetchedRecipes = fetchedRecipes.map { recipeUi ->
            if (recipeUi.recipe.id == recipeId) {
                recipeUi.copy(isFavourite = !recipeUi.isFavourite)
            } else recipeUi
        }
        uiState = UiState.Success(fetchedRecipes)
    }

    /* TODO
    val filteredRecipes
        get() =
            if (selectedFilters.isEmpty()) recipes
            else recipes.filter { selectedFilters.contains(it.type) }
     */
}