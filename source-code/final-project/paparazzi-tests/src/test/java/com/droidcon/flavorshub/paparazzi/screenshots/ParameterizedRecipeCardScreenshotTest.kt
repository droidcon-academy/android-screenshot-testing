package com.droidcon.flavorshub.paparazzi.screenshots

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.android.resources.NightMode
import com.droidcon.flavorshub.ui.model.FavoriteState
import com.droidcon.flavorshub.ui.model.Type
import com.droidcon.flavorshub.ui.screens.main.model.MainScreenRecipeItem
import com.droidcon.flavorshub.ui.screens.main.ui.RecipeCard
import com.droidcon.flavorshub.ui.theme.FlavorshubTheme
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Execute the following command for this screenshot
 * ./gradlew :paparazzi-tests:recordPaparazziDebug --tests 'ParameterizedRecipeCardScreenshotTest'
 */
@RunWith(TestParameterInjector::class)
class ParameterizedRecipeCardScreenshotTest(
    @TestParameter val nightMode: NightMode,
    @TestParameter val recipeInLocale: RecipeInLocale
) {

    enum class RecipeInLocale(
        val localeAsString: String,
        val mainScreenRecipeItem: MainScreenRecipeItem
    ) {
        ENGLISH(
            localeAsString ="en",
            mainScreenRecipeItem = MainScreenRecipeItem(
                id = 1,
                name = "Recipe Title",
                shortDescription = "Recipe Description",
                type = Type.MEAT,
                cookingTimeInMin = 30,
                isFavorite = FavoriteState.FAVORITE,
                imageUrl = "https://example.com/recipe-image.jpg"
            )
        ),
        ARABIC(
            localeAsString = "ar",
            mainScreenRecipeItem = MainScreenRecipeItem(
                id = 2,
                name = "عنوان الوصفة",
                shortDescription = "وصف الوصفة",
                type = Type.VEGAN,
                cookingTimeInMin = 30,
                isFavorite = FavoriteState.NOT_FAVORITE,
                imageUrl = "https://example.com/recipe-image.jpg"
            ))
    }

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig(
            nightMode = nightMode,
            locale = recipeInLocale.localeAsString
        ),
        supportsRtl = true,
        renderingMode = SessionParams.RenderingMode.SHRINK
    )

    @Test
    fun recipeCardScreenshot() {
        paparazzi.snapshot(name = "Recipe Card screenshot") {
            CompositionLocalProvider(LocalInspectionMode provides true) {
                FlavorshubTheme {
                    RecipeCard(
                        modifier = Modifier.Companion,
                        recipe = recipeInLocale.mainScreenRecipeItem,
                        onFavouriteClick = { id -> },
                        onClick = { }
                    )
                }
            }
        }
    }
}