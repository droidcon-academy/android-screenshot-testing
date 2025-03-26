package com.droidcon.flavorshub.ui.mainscreen

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import com.droidcon.flavorshub.model.BottomNavItem
import com.droidcon.flavorshub.model.screens.MainScreenRecipeItem
import kotlinx.collections.immutable.ImmutableList

sealed interface MainScreenRecipeContent {
    @Composable
    fun Display()

    class Recipes(
        private val homeScrollState: LazyListState,
        private val favoritesScrollState : LazyListState,
        private val recipes: ImmutableList<MainScreenRecipeItem>,
        private val selectedBottomNavItem: BottomNavItem,
        private val onToggleFavorite: (Int) -> Unit,
        private val onRecipeClick: (Int) -> Unit,
    ) : MainScreenRecipeContent {
        @Composable
        override fun Display() {
            RecipesContent(
                homeScrollState = homeScrollState,
                favoritesScrollState = favoritesScrollState,
                recipes = recipes,
                selectedBottomNavItem = selectedBottomNavItem,
                onToggleFavorite = onToggleFavorite,
                onRecipeClick = onRecipeClick
            )
        }
    }

    object NoRecipes : MainScreenRecipeContent {
        @Composable
        override fun Display() {
            EmptyContent()
        }
    }
}