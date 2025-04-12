package com.droidcon.flavorshub.roborazzi.screenshots

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.droidcon.flavorshub.FlavorshubActivity
import com.droidcon.flavorshub.roborazzi.screenshots.interactor.ScreenInteractor
import com.droidcon.flavorshub.roborazzi.screenshots.testrules.AddActivityToRobolectricRule
import com.droidcon.flavorshub.roborazzi.screenshots.testrules.FakeImageLoaderRule
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.RoborazziRule.Options
import com.google.testing.junit.testparameterinjector.TestParameter
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestParameterInjector
import org.robolectric.RuntimeEnvironment.setFontScale
import org.robolectric.RuntimeEnvironment.setQualifiers
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

/**
 * Execute the following command for this screenshot
 * ./gradlew :roborazzi-tests:recordRoborazziDebug --tests 'ParameterizedMultiFrameScreenshotTest'
 */
@HiltAndroidTest
@RunWith(RobolectricTestParameterInjector::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(application = HiltTestApplication::class)
class ParameterizedMultiFrameScreenshotTest(
    @TestParameter val device: DeviceQualifier,
    @TestParameter val nightMode: NightMode,
    @TestParameter val locale: Locale,
    @TestParameter val fontSize: FontSize
) {

    enum class FontSize(val scale: Float) {
        NORMAL(1.0f),
        // LARGE(1.3f)
    }

    enum class Locale(val cumulativeQualifier: String) {
        ENGLISH("+en"),
        ARABIC("+ar")
    }

    enum class NightMode(val cumulativeQualifier: String) {
        LIGHT("+notnight"),
        DARK("+night")
    }

    enum class DeviceQualifier(val qualifier: String) {
        //TABLET(RobolectricDeviceQualifiers.PixelC),
        PIXEL(RobolectricDeviceQualifiers.Pixel4)
    }

    @get:Rule(order = 0)
    val fakeImageLoaderRule = FakeImageLoaderRule { getApplicationContext() }

    @get:Rule(order = 1)
    val addActivityToRobolectricRule =
        AddActivityToRobolectricRule(FlavorshubActivity::class.java)

    @get:Rule(order = 2)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 3)
    val robolectricQualifiersRule = object : TestWatcher() {
        override fun starting(description: Description) {
            setQualifiers(device.qualifier)
            setQualifiers(nightMode.cumulativeQualifier)
            setQualifiers(locale.cumulativeQualifier)
            setFontScale(fontSize.scale)
        }
    }

    @get:Rule(order = 4)
    val composeTestRule = createAndroidComposeRule<FlavorshubActivity>()

    @get:Rule(order = 5)
    val roborazziRule =
        RoborazziRule(
            composeRule = composeTestRule,
            captureRoot = composeTestRule.onRoot(),
            options = Options(
                captureType = RoborazziRule.CaptureType.Gif(),
            ),
        )

    @Test
    fun multiFrameScreenshots() {
        ScreenInteractor(composeTestRule).run {
            captureScreenshot("Show Home")

            addToFavoritesButtonInRecipeAtIndex(0).performClick()
            captureScreenshot("Added 1st recipe to favorites")

            bottomTabFavorites().performClick()
            captureScreenshot("Show Favorites")

            recipeImageAtIndex(0).performClick()
            captureScreenshot("Show Favorite Recipe Screen")

            pressBack()
            captureScreenshot("Back in Favorites")

            removeFromFavoritesButtonInRecipeAtIndex(0).performClick()
            captureScreenshot("Favorite removed")
        }
    }
}