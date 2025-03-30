package com.droidcon.flavorshub.screens.recipedetails.ui

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.droidcon.flavorshub.screens.recipedetails.viewmodel.RecipeDetailsScreenViewModel
import com.droidcon.flavorshub.ui.screens.recipedetails.ui.RecipeDetailsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreenEntryPoint(
    viewModel: RecipeDetailsScreenViewModel = hiltViewModel(),
    recipeId: Int,
    onBackPressed: () -> Unit
) {
    val recipe = viewModel.fetchRecipeInCurrentLocaleById(recipeId)
    val scrollState = rememberScrollState()

    RecipeDetailsScreen(
        scrollState = scrollState,
        recipe = recipe,
        onBackPressed = onBackPressed
    )
}