package com.droidcon.flavorshub.roborazzi.screenshots

import com.droidcon.flavorshub.ui.R
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.droidcon.flavorshub.FlavorshubActivity
import com.droidcon.flavorshub.roborazzi.screenshots.testrules.AddActivityToRobolectricRule
import com.droidcon.flavorshub.roborazzi.screenshots.testrules.FakeImageLoaderRule
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.RoborazziRule.Options
import com.github.takahirom.roborazzi.captureRoboImage
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

/**
 * Execute the following command for this screenshot
 * ./gradlew :roborazzi-tests:recordRoborazziDebug --tests 'SimpleRoborazziScreenshotTest'
 */
@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(application = HiltTestApplication::class)
class ParameterizedRoborazziScreenshotTest {

    @get:Rule(order = 0)
    val fakeImageLoaderRule = FakeImageLoaderRule { getApplicationContext() }

    @get:Rule(order = 1)
    val addActivityToRobolectricRule =
        AddActivityToRobolectricRule(FlavorshubActivity::class.java)

    @get:Rule(order = 2)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 3)
    val composeTestRule = createAndroidComposeRule<FlavorshubActivity>()

    @get:Rule(order = 4)
    val roborazziRule =
        RoborazziRule(
            composeRule = composeTestRule,
            captureRoot = composeTestRule.onRoot(),
            options = Options(
                captureType = RoborazziRule.CaptureType.Gif(),
            ),
        )

    fun stringRes(stringRes: Int, vararg formatArgs: Any) =
        composeTestRule.activity.getString(stringRes, *formatArgs)

    @Config(qualifiers = RobolectricDeviceQualifiers.Pixel4)
    @Test
    fun multiFrameScreenshots() {
        composeTestRule.run {
            onRoot().captureRoboImage("Home-BottomTab")

            onAllNodesWithContentDescription(
                label = stringRes(R.string.add_to_favorites_icon),
                useUnmergedTree = true
            )[0].performClick()

        }
        composeTestRule.onRoot().captureRoboImage("Home-BottomTab")

        composeTestRule.onAllNodesWithContentDescription(
            label = stringRes(R.string.add_to_favorites_icon),
            useUnmergedTree = true
        )[0].performClick()
        composeTestRule.onRoot().captureRoboImage("Added to favorites")

        composeTestRule.onNodeWithText(stringRes(R.string.bottom_nav_Favorites)).performClick()
        composeTestRule.onRoot().captureRoboImage("Favorites-BottomTab")

        composeTestRule.onAllNodesWithContentDescription(
            label = stringRes(R.string.recipe_image_content_description, ""),
            substring = true,
            useUnmergedTree = true
        )[0].performClick()

        composeTestRule.onRoot().captureRoboImage("Detail-Screen")

        composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
        composeTestRule.onRoot().captureRoboImage("Back in Favorites")

        composeTestRule.onAllNodesWithContentDescription(
            label = stringRes(R.string.remove_from_favorites_icon),
            useUnmergedTree = true
        )[0].performClick()
        composeTestRule.onRoot().captureRoboImage("Removed from favorites")
    }
}