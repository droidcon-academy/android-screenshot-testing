package com.droidcon.flavorshub.paparazzi.screenshots

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import app.cash.paparazzi.Paparazzi
import coil3.ColorImage
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.annotation.DelicateCoilApi
import coil3.annotation.ExperimentalCoilApi
import coil3.test.FakeImageLoaderEngine
import com.android.ide.common.rendering.api.SessionParams
import com.droidcon.flavorshub.ui.model.FavoriteState
import com.droidcon.flavorshub.ui.model.Type
import com.droidcon.flavorshub.ui.screens.main.model.MainScreenRecipeItem
import com.droidcon.flavorshub.ui.screens.main.ui.RecipeCard
import com.droidcon.flavorshub.ui.theme.FlavorshubTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Execute the following command for this screenshot
 * ./gradlew :paparazzi-tests:recordPaparazziDebug --tests 'SimpleRecipeCardScreenshotTest'
 */
class SimpleRecipeCardScreenshotTest {

    @get:Rule
    val paparazzi = Paparazzi(
        renderingMode = SessionParams.RenderingMode.SHRINK
    )

    @OptIn(DelicateCoilApi::class, ExperimentalCoilApi::class)
    @Before
    fun before() {
        val engine = FakeImageLoaderEngine.Builder()
            .intercept({ request -> true }, ColorImage(Color.Green.toArgb()))
            .build()
        val imageLoader = ImageLoader.Builder(paparazzi.context)
            .components { add(engine) }
            .build()
        SingletonImageLoader.setUnsafe(imageLoader)
    }

    @Test
    fun recipeCardScreenshot() {
        paparazzi.snapshot(name = "Recipe Card screenshot") {
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