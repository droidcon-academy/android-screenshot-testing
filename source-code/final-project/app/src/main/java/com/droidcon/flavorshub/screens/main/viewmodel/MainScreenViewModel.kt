package com.droidcon.flavorshub.screens.main.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.droidcon.flavorshub.ui.model.BottomNavItem
import com.droidcon.flavorshub.ui.model.FavoriteState
import com.droidcon.flavorshub.ui.model.Type
import com.droidcon.flavorshub.repositories.RecipesRepo
import com.droidcon.flavorshub.ui.screens.main.model.MainScreenRecipeItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject
import kotlin.collections.map

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
        sealed class RecipesContent : ContentState() {
            abstract val recipes: ImmutableList<MainScreenRecipeItem>
            data class Home(override val recipes: ImmutableList<MainScreenRecipeItem>) : RecipesContent()
            data class Favorites(override val recipes: ImmutableList<MainScreenRecipeItem>) : RecipesContent()
        }
        object Empty : ContentState()
    }

    private var userFavorites: MutableSet<Int> = mutableSetOf()
    private var selectedBottomNavItem: BottomNavItem = BottomNavItem.HOME
    private var selectedRecipeFilter: MutableSet<Type> = Type.entries.toMutableSet()

    private val _screenUiState = mutableStateOf<ScreenUiState>(
        ScreenUiState(
            selectedRecipeFilter = selectedRecipeFilter.toImmutableList(),
            content = ContentState.Empty,
            selectedNavItem = BottomNavItem.HOME
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
        // Ensure the recipes are in the language of the User before rendering the UI
        val recipesInCurrentLocale = recipesRepo.fetchRecipesInCurrentLocale()
            .map { recipeItem ->
                val recipe = recipeItem.recipe
                MainScreenRecipeItem(
                    id = recipe.id,
                    name = recipe.name,
                    cookingTimeInMin = recipe.cookingTimeInMin,
                    shortDescription = recipe.shortDescription,
                    type = recipe.type,
                    imageUrl = recipe.imageUrl,
                    isFavorite = when(userFavorites.contains(recipe.id) || recipeItem.isFavourite) {
                        true -> FavoriteState.FAVORITE
                        false -> FavoriteState.NOT_FAVORITE
                    }
                )
            }

        val filteredRecipes = when (selectedBottomNavItem) {
            BottomNavItem.HOME -> recipesInCurrentLocale
            BottomNavItem.FAVOURITES -> recipesInCurrentLocale.filter { it.isFavorite == FavoriteState.FAVORITE }
        }.filter { selectedRecipeFilter.contains(it.type) }

        val contentState = when (filteredRecipes.isEmpty()) {
            true -> ContentState.Empty
            false -> when (selectedBottomNavItem) {
                BottomNavItem.HOME -> ContentState.RecipesContent.Home(filteredRecipes.toImmutableList())
                BottomNavItem.FAVOURITES -> ContentState.RecipesContent.Favorites(filteredRecipes.toImmutableList())
            }
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