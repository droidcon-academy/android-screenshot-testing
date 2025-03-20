package com.droidcon.flavorshub.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.droidcon.flavorshub.model.BottomNavItem
import com.droidcon.flavorshub.model.BottomNavItem.FAVOURITES
import com.droidcon.flavorshub.model.BottomNavItem.HOME
import com.droidcon.flavorshub.model.RecipeCardItem
import com.droidcon.flavorshub.model.Type
import com.droidcon.flavorshub.viewmodels.HomeViewModel.UiState.Success

class HomeViewModel : ViewModel() {

    sealed class UiState {
        data class Success(
            val selectedRecipeFilter: List<Type>,
            val recipes: List<RecipeCardItem>,
            val selectedNavItem: BottomNavItem
        ) : UiState()
        // TODO - check which states are necessary
        // object Loading : UiState()
        // data class Error(val message: String) : UiState()
    }

    private val recipesRepo = RecipesRepo()
    private var fetchedRecipes: List<RecipeCardItem> = recipesRepo.fetchRecipes()
    private var selectedBottomNavItem: BottomNavItem = HOME
    private var selectedRecipeFilter: List<Type> = Type.entries.toList()

    var uiState by mutableStateOf<UiState>(
        Success(
            selectedRecipeFilter = selectedRecipeFilter,
            recipes = fetchedRecipes,
            selectedNavItem = HOME
        )
    )
        private set

    fun toggleFavorite(recipeId: Int) {
        fetchedRecipes = fetchedRecipes.map { recipeUi ->
            when (recipeUi.recipe.id == recipeId) {
                true -> recipeUi.copy(isFavourite = !recipeUi.isFavourite)
                else -> recipeUi
            }
        }
        uiState = Success(
            selectedRecipeFilter,
            navItemRecipes(selectedBottomNavItem),
            selectedBottomNavItem
        )
    }

    fun toggleFilter(recipeFilter: Type) {
        selectedRecipeFilter =
            if (selectedRecipeFilter.contains(recipeFilter)) {
                selectedRecipeFilter.minus(recipeFilter)
            } else {
                selectedRecipeFilter.plus(recipeFilter)
            }

        uiState = Success(
            selectedRecipeFilter,
            navItemRecipes(selectedBottomNavItem),
            selectedBottomNavItem
        )
    }

    // TODO - create separate list for favourites -> favourites displayed in "favourite" order
    private fun navItemRecipes(bottomNavItem: BottomNavItem): List<RecipeCardItem> =
        when (bottomNavItem) {
            HOME -> fetchedRecipes
            FAVOURITES -> fetchedRecipes.filter { it.isFavourite }
        }
            .filter { selectedRecipeFilter.contains(it.recipe.type) }

    fun onNavItemClick(bottomNavItem: BottomNavItem) {
        selectedBottomNavItem = bottomNavItem
        uiState = Success(
            selectedRecipeFilter,
            navItemRecipes(selectedBottomNavItem),
            selectedBottomNavItem
        )
    }

    /* TODO
    val filteredRecipes
        get() =
            if (selectedFilters.isEmpty()) recipes
            else recipes.filter { selectedFilters.contains(it.type) }
     */
}