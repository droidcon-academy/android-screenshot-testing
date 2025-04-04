package com.droidcon.flavorshub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.droidcon.flavorshub.navigation.NavigationDestinations.MAIN_SCREEN
import com.droidcon.flavorshub.navigation.NavigationDestinations.RECIPE_ID_KEY
import com.droidcon.flavorshub.screens.main.ui.MainScreenEntryPoint
import com.droidcon.flavorshub.screens.recipedetails.ui.RecipeDetailsScreenEntryPoint

object NavigationDestinations {
    const val MAIN_SCREEN = "main_screen"
    const val RECIPE_DETAILS_SCREEN = "recipe_details_screen"
    const val RECIPE_ID_KEY = "recipeId"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MAIN_SCREEN
    ) {
        composable(MAIN_SCREEN) {
            MainScreenEntryPoint(navController = navController)
        }

        composable(
            route = "${NavigationDestinations.RECIPE_DETAILS_SCREEN}/{${RECIPE_ID_KEY}}",
            arguments = listOf(
                navArgument(RECIPE_ID_KEY) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val recipeId = requireNotNull(backStackEntry.arguments).getInt(RECIPE_ID_KEY)
            RecipeDetailsScreenEntryPoint(
                recipeId = recipeId,
                onBackPressed = { navController.popBackStack() }
            )

        }
    }
}

fun NavController.navigateToRecipeDetails(recipeId: Int) {
    this.navigate("${NavigationDestinations.RECIPE_DETAILS_SCREEN}/$recipeId")
}