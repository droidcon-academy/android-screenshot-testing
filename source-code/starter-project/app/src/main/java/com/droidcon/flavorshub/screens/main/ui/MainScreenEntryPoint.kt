package com.droidcon.flavorshub.screens.main.ui

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.droidcon.flavorshub.navigation.navigateToRecipeDetails
import com.droidcon.flavorshub.screens.main.viewmodel.MainScreenViewModel
import com.droidcon.flavorshub.screens.main.viewmodel.MainScreenViewModel.ContentState.Empty
import com.droidcon.flavorshub.screens.main.viewmodel.MainScreenViewModel.ContentState.RecipesContent
import com.droidcon.flavorshub.ui.screens.main.ui.MainScreen
import com.droidcon.flavorshub.ui.screens.main.ui.MainScreenRecipeContent.NoRecipes
import com.droidcon.flavorshub.ui.screens.main.ui.MainScreenRecipeContent.Recipes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenEntryPoint(
    viewModel: MainScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    val homeScrollState = rememberLazyListState()
    val favoritesScrollState = rememberLazyListState()

    val mainScreenRecipeContent = when (val contentState = viewModel.screenUiState.content) {
        is RecipesContent -> {
            val scrollState = when(contentState) {
                is RecipesContent.Favorites -> favoritesScrollState
                is RecipesContent.Home -> homeScrollState
            }
            Recipes(
                scrollState = scrollState,
                recipes = contentState.recipes,
                onToggleFavorite = { id -> viewModel.toggleFavorite(id) },
                onRecipeClick = { id -> navController.navigateToRecipeDetails(id) }
            )
        }
        Empty -> NoRecipes
    }

    MainScreen(
        selectedBottomNavItem = viewModel.screenUiState.selectedNavItem,
        selectedFilters = viewModel.screenUiState.selectedRecipeFilter,
        onBottomNavItemClick = { navItem -> viewModel.onNavItemClick(navItem) },
        onToggleFilter = { filter -> viewModel.toggleFilter(filter) },
        content = mainScreenRecipeContent
    )
}