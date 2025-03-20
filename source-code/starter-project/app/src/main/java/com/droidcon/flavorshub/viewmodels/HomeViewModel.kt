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
import com.droidcon.flavorshub.viewmodels.HomeViewModel.UiState.*
import com.droidcon.flavorshub.viewmodels.HomeViewModel.UiState.Content

class HomeViewModel : ViewModel() {

    sealed class UiState {
        data class Content(
            val selectedRecipeFilter: List<Type>,
            val recipes: List<RecipeCardItem>,
            val selectedNavItem: BottomNavItem
        ) : UiState()

        data class Empty(
            val selectedRecipeFilter: List<Type>,
            val selectedNavItem: BottomNavItem
        ) : UiState()
    }

    private val recipesRepo = RecipesRepo()
    private var fetchedRecipes: List<RecipeCardItem> = recipesRepo.fetchRecipes()
    private var selectedBottomNavItem: BottomNavItem = HOME
    private var selectedRecipeFilter: List<Type> = Type.entries.toList()

    var uiState by mutableStateOf<UiState>(
        Content(
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
        uiState = computeUiState()
    }

    fun toggleFilter(recipeFilter: Type) {
        selectedRecipeFilter =
            when (selectedRecipeFilter.contains(recipeFilter)) {
                true -> selectedRecipeFilter.minus(recipeFilter)
                false -> selectedRecipeFilter.plus(recipeFilter)
            }
        uiState = computeUiState()
    }

    private fun computeUiState(): UiState {
        val content = navItemRecipes(selectedBottomNavItem)
        return when (content.isEmpty()) {
            true -> Empty(selectedRecipeFilter, selectedBottomNavItem)
            false -> Content(selectedRecipeFilter, content, selectedBottomNavItem)
        }
    }

    fun onNavItemClick(bottomNavItem: BottomNavItem) {
        selectedBottomNavItem = bottomNavItem
        uiState = computeUiState()
    }

    private fun navItemRecipes(bottomNavItem: BottomNavItem): List<RecipeCardItem> =
        when (bottomNavItem) {
            HOME -> fetchedRecipes
            FAVOURITES -> fetchedRecipes.filter { it.isFavourite }
        }
            .filter { selectedRecipeFilter.contains(it.recipe.type) }
}