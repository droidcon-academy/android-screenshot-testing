package com.droidcon.flavorshub.ui.screens.main.ui

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import com.droidcon.flavorshub.ui.screens.main.model.MainScreenRecipeItem
import kotlinx.collections.immutable.ImmutableList

sealed interface MainScreenRecipeContent {
    @Composable
    fun Display()

    class Recipes(
        private val scrollState: LazyListState,
        private val recipes: ImmutableList<MainScreenRecipeItem>,
        private val onToggleFavorite: (Int) -> Unit,
        private val onRecipeClick: (Int) -> Unit,
    ) : MainScreenRecipeContent {
        @Composable
        override fun Display() {
            RecipesContent(
                scrollState = scrollState,
                recipes = recipes,
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