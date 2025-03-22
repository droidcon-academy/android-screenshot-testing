package com.droidcon.flavorshub.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.droidcon.flavorshub.model.BottomNavItem
import com.droidcon.flavorshub.model.BottomNavItem.FAVOURITES
import com.droidcon.flavorshub.model.BottomNavItem.HOME
import com.droidcon.flavorshub.model.screens.MainScreenRecipeItem
import com.droidcon.flavorshub.model.Type
import com.droidcon.flavorshub.viewmodels.MainScreenViewModel.ContentState.Content
import com.droidcon.flavorshub.viewmodels.MainScreenViewModel.ContentState.Empty
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

class MainScreenViewModel : ViewModel() {

    data class UiState(
        val selectedRecipeFilter: ImmutableList<Type>,
        val content: ContentState,
        val selectedNavItem: BottomNavItem,
    )

    sealed class ContentState {
        data class Content(val recipes: ImmutableList<MainScreenRecipeItem>) : ContentState()
        object Empty : ContentState()
    }

    private val recipesRepo = RecipesRepo()
    private var fetchedRecipes: List<MainScreenRecipeItem> =
        recipesRepo.fetchRecipes().map { recipeItem ->
            val recipe = recipeItem.recipe
            MainScreenRecipeItem(
                id = recipe.id,
                name = recipe.name,
                cookingTimeInMin = recipe.cookingTimeInMin,
                shortDescription = recipe.shortDescription,
                type = recipe.type,
                imageUrl = recipe.imageUrl,
                isFavorite = recipeItem.isFavourite
            )
        }
    private var selectedBottomNavItem: BottomNavItem = HOME
    private var selectedRecipeFilter: List<Type> = Type.entries.toList()

    var uiState by mutableStateOf<UiState>(
        UiState(
            selectedRecipeFilter = selectedRecipeFilter.toImmutableList(),
            content = Content(fetchedRecipes.toImmutableList()),
            selectedNavItem = HOME
        )
    )
        private set

    fun toggleFavorite(recipeId: Int) {
        fetchedRecipes = fetchedRecipes.map { recipeUi ->
            when (recipeUi.id == recipeId) {
                true -> recipeUi.copy(isFavorite = !recipeUi.isFavorite)
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
        val contentState = when (content.isEmpty()) {
            true -> Empty
            false -> Content(content.toImmutableList())
        }
        return UiState(selectedRecipeFilter.toImmutableList(), contentState, selectedBottomNavItem)
    }

    fun onNavItemClick(bottomNavItem: BottomNavItem) {
        selectedBottomNavItem = bottomNavItem
        uiState = computeUiState()
    }

    private fun navItemRecipes(bottomNavItem: BottomNavItem): List<MainScreenRecipeItem> =
        when (bottomNavItem) {
            HOME -> fetchedRecipes
            FAVOURITES -> fetchedRecipes.filter { it.isFavorite }
        }
            .filter { selectedRecipeFilter.contains(it.type) }
}