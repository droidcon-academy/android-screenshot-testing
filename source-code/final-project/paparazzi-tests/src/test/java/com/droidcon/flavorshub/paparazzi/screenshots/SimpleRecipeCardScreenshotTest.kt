package com.droidcon.flavorshub.paparazzi.screenshots

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.droidcon.flavorshub.ui.model.FavoriteState
import com.droidcon.flavorshub.ui.model.Type
import com.droidcon.flavorshub.ui.screens.main.model.MainScreenRecipeItem
import com.droidcon.flavorshub.ui.screens.main.ui.RecipeCard
import com.droidcon.flavorshub.ui.theme.FlavorshubTheme
import org.junit.Rule
import org.junit.Test

/**
 * Execute the following command for this screenshot
 * ./gradlew :paparazzi-tests:recordPaparazziDebug
 */
class SimpleRecipeCardScreenshotTest {

    @get:Rule
    val paparazzi = Paparazzi(
        renderingMode = SessionParams.RenderingMode.SHRINK
    )

    @Test
    fun recipeCardScreenshot() {
        paparazzi.snapshot(name = "Recipe Card screenshot") {
            CompositionLocalProvider(LocalInspectionMode provides true) {
                FlavorshubTheme {
                    RecipeCard(
                        modifier = Modifier.Companion,
                        recipe = MainScreenRecipeItem(
                            id = 1,
                            name = "Recipe Title",
                            shortDescription = "Recipe Description",
                            type = Type.VEGAN,
                            cookingTimeInMin = 30,
                            isFavorite = FavoriteState.FAVORITE,
                            imageUrl = "https://example.com/recipe-image.jpg"
                        ),
                        onFavouriteClick = { id -> },
                        onClick = { }
                    )
                }
            }
        }
    }
}