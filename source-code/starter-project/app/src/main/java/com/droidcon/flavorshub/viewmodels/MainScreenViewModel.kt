package com.droidcon.flavorshub.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.droidcon.flavorshub.model.BottomNavItem
import com.droidcon.flavorshub.model.BottomNavItem.FAVOURITES
import com.droidcon.flavorshub.model.BottomNavItem.HOME
import com.droidcon.flavorshub.model.Type
import com.droidcon.flavorshub.model.screens.MainScreenRecipeItem
import com.droidcon.flavorshub.viewmodels.MainScreenViewModel.ContentState.Content
import com.droidcon.flavorshub.viewmodels.MainScreenViewModel.ContentState.Empty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val recipesRepo: RecipesRepo
) : ViewModel() {

    data class ScreenUiState(
        val selectedRecipeFilter: ImmutableList<Type>,
        val content: ContentState,
        val selectedNavItem: BottomNavItem,
    )

    sealed class ContentState {
        data class Content(val recipes: ImmutableList<MainScreenRecipeItem>) : ContentState()
        object Empty : ContentState()
    }

    private var userFavorites: MutableSet<Int> = mutableSetOf()
    private var selectedBottomNavItem: BottomNavItem = HOME
    private var selectedRecipeFilter: MutableSet<Type> = Type.entries.toMutableSet()

    private val _screenUiState = mutableStateOf<ScreenUiState>(
        ScreenUiState(
            selectedRecipeFilter = selectedRecipeFilter.toImmutableList(),
            content = Empty,
            selectedNavItem = HOME
        )
    )

    var screenUiState: ScreenUiState
        get() {
            computeState()
            return _screenUiState.value
        }
        private set(value) {
            _screenUiState.value = value
        }

    init {
        computeState()
    }

    private fun computeState() {
        val recipesInCurrentLocale = recipesRepo.fetchRecipesInCurrentLocale().map { recipeItem ->
            val recipe = recipeItem.recipe
            MainScreenRecipeItem(
                id = recipe.id,
                name = recipe.name,
                cookingTimeInMin = recipe.cookingTimeInMin,
                shortDescription = recipe.shortDescription,
                type = recipe.type,
                imageUrl = recipe.imageUrl,
                isFavorite = userFavorites.contains(recipe.id) || recipeItem.isFavourite
            )
        }

        val filteredRecipes = when (selectedBottomNavItem) {
            HOME -> recipesInCurrentLocale
            FAVOURITES -> recipesInCurrentLocale.filter { it.isFavorite }
        }.filter { selectedRecipeFilter.contains(it.type) }

        val contentState = when (filteredRecipes.isEmpty()) {
            true -> Empty
            false -> Content(filteredRecipes.toImmutableList())
        }

        screenUiState = ScreenUiState(
            selectedRecipeFilter = selectedRecipeFilter.toImmutableList(),
            content = contentState,
            selectedNavItem = selectedBottomNavItem
        )
    }

    fun toggleFavorite(recipeId: Int) {
        when (userFavorites.contains(recipeId)) {
            true -> userFavorites.remove(recipeId)
            false -> userFavorites.add(recipeId)
        }
        computeState()
    }

    fun toggleFilter(recipeFilter: Type) {
        when (selectedRecipeFilter.contains(recipeFilter)) {
            true -> selectedRecipeFilter.remove(recipeFilter)
            false -> selectedRecipeFilter.add(recipeFilter)
        }
        computeState()
    }

    fun onNavItemClick(bottomNavItem: BottomNavItem) {
        selectedBottomNavItem = bottomNavItem
        computeState()
    }
}