package com.droidcon.flavorshub.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.droidcon.flavorshub.viewmodels.HomeViewModel.NavItem.FAVOURITES
import com.droidcon.flavorshub.viewmodels.HomeViewModel.NavItem.HOME
import com.droidcon.flavorshub.viewmodels.model.Recipe

class HomeViewModel : ViewModel() {
    // State for the UI
    data class RecipeUi(
        val recipe: Recipe,
        val isFavourite: Boolean
    )

    sealed class UiState {
        data class Success(
            val recipes: List<RecipeUi>,
            val selectedNavItem: NavItem
        ) : UiState()
        // TODO - check which states are necessary
        // object Loading : UiState()
        // data class Error(val message: String) : UiState()
    }

    enum class NavItem {
        HOME, FAVOURITES
    }

    private val recipesRepo = RecipesRepo()
    private var fetchedRecipes: List<RecipeUi> = recipesRepo.fetchRecipes()
    private var selectedNavItem: NavItem = HOME

    var uiState by mutableStateOf<UiState>(
        UiState.Success(
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
        uiState = UiState.Success(navItemRecipes(selectedNavItem), selectedNavItem)
    }

    // TODO - create separate list for favourites -> favourites displayed in "favourite" order
    private fun navItemRecipes(navItem: NavItem): List<RecipeUi> {
        return when (navItem) {
            HOME -> fetchedRecipes
            FAVOURITES -> fetchedRecipes.filter { it.isFavourite }
        }
    }

    fun onHomeScreenNavClicked() {
        selectedNavItem = HOME
        uiState = UiState.Success(navItemRecipes(selectedNavItem), selectedNavItem)
    }

    fun onFavouritesNavClicked() {
        selectedNavItem = FAVOURITES
        uiState = UiState.Success(navItemRecipes(selectedNavItem), selectedNavItem)
    }

    /* TODO
    val filteredRecipes
        get() =
            if (selectedFilters.isEmpty()) recipes
            else recipes.filter { selectedFilters.contains(it.type) }
     */
}