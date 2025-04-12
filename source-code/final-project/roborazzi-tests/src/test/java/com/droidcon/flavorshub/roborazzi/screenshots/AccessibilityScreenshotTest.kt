package com.droidcon.flavorshub.roborazzi.screenshots

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.droidcon.flavorshub.roborazzi.screenshots.testrules.FakeImageLoaderRule
import com.droidcon.flavorshub.ui.model.BottomNavItem.HOME
import com.droidcon.flavorshub.ui.model.FavoriteState.FAVORITE
import com.droidcon.flavorshub.ui.model.FavoriteState.NOT_FAVORITE
import com.droidcon.flavorshub.ui.model.Type.FISH
import com.droidcon.flavorshub.ui.model.Type.MEAT
import com.droidcon.flavorshub.ui.screens.main.model.MainScreenRecipeItem
import com.droidcon.flavorshub.ui.screens.main.ui.MainScreen
import com.droidcon.flavorshub.ui.screens.main.ui.MainScreenRecipeContent.Recipes
import com.droidcon.flavorshub.ui.theme.FlavorshubTheme
import com.github.takahirom.roborazzi.Dump
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.captureRoboImage
import kotlinx.collections.immutable.toImmutableList
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

/**
 * Execute the following command for this screenshot
 * ./gradlew :roborazzi-tests:recordRoborazziDebug --tests 'AccessibilityScreenshotTest'
 */
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class AccessibilityScreenshotTest {

    @get:Rule(order = 0)
    val fakeImageLoaderRule = FakeImageLoaderRule { getApplicationContext() }

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    private val recipes = listOf(
        MainScreenRecipeItem(
            id = 1,
            name = "Recipe 1",
            shortDescription = "Description 1",
            cookingTimeInMin = 30,
            type = MEAT,
            imageUrl = "https://example.com/recipe1.jpg",
            isFavorite = NOT_FAVORITE
        ),
        MainScreenRecipeItem(
            id = 2,
            name = "Recipe 2",
            shortDescription = "Description 2",
            cookingTimeInMin = 30,
            type = FISH,
            imageUrl = "https://example.com/recipe1.jpg",
            isFavorite = FAVORITE
        )
    ).toImmutableList()

    @Config(qualifiers = RobolectricDeviceQualifiers.Pixel4)
    @Test
    fun multiFrameScreenshots() {
        composeTestRule.setContent {
            FlavorshubTheme {
                MainScreen(
                    content = Recipes(
                        scrollState = rememberLazyListState(),
                        recipes = recipes,
                        onToggleFavorite = {},
                        onRecipeClick = {}
                    ),
                    selectedBottomNavItem = HOME,
                    onToggleFilter = {},
                    selectedFilters = listOf(MEAT).toImmutableList(),
                    onBottomNavItemClick = {},
                )
            }
        }
        composeTestRule.onRoot().captureRoboImage(
            filePath = "Main Screen Accessibility.png",
            roborazziOptions = RoborazziOptions(
                captureType = RoborazziOptions.CaptureType.Dump(
                    explanation = Dump.Companion.AccessibilityExplanation
                )
            )
        )
    }
}