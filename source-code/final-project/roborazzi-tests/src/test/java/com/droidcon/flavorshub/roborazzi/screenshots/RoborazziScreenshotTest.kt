package com.droidcon.flavorshub.roborazzi.screenshots

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import android.app.Application
import android.content.ComponentName
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import coil3.ColorImage
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.annotation.DelicateCoilApi
import coil3.annotation.ExperimentalCoilApi
import coil3.test.FakeImageLoaderEngine
import com.droidcon.flavorshub.FlavorshubActivity
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.RoborazziRule.Options
import com.github.takahirom.roborazzi.captureRoboImage
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import java.util.concurrent.atomic.AtomicInteger

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(application = HiltTestApplication::class)
class RoborazziScreenshotTest {

    @OptIn(ExperimentalCoilApi::class, DelicateCoilApi::class)
    @get:Rule(order = 0)
    val fakeImageLoaderRule = object : TestWatcher() {
        override fun starting(description: Description?) {
            super.starting(description)
            val requestCounter = AtomicInteger(0)
            val engine = FakeImageLoaderEngine.Builder()
                .intercept({ request -> requestCounter.getAndIncrement() == 0 }, ColorImage(Color.Red.toArgb()))
                .intercept({ request -> true }, ColorImage(Color.Green.toArgb()))
                .build()
            val imageLoader = ImageLoader.Builder(ApplicationProvider.getApplicationContext())
                .components { add(engine) }
                .build()
            SingletonImageLoader.setUnsafe(imageLoader)
        }
    }

    @get:Rule(order = 1)
    val addActivityToRobolectricRule = object : TestWatcher() {
        override fun starting(description: Description?) {
            super.starting(description)
            val appContext: Application = ApplicationProvider.getApplicationContext()
            Shadows.shadowOf(appContext.packageManager).addActivityIfNotPresent(
                ComponentName(
                    appContext.packageName,
                    FlavorshubActivity::class.java.name,
                )
            )
        }
    }

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

    @Config(qualifiers = RobolectricDeviceQualifiers.Pixel4)
    @Test
    fun composable() {
        composeTestRule.onRoot().captureRoboImage("Home-BottomTab")

        composeTestRule.onAllNodesWithContentDescription(
            label = "Add to favorites icon",
            useUnmergedTree = true
        )[0].performClick()
        composeTestRule.onRoot().captureRoboImage("Added to favorites")

        composeTestRule.onNodeWithText("Favorites").performClick()
        composeTestRule.onRoot().captureRoboImage("Favorites-BottomTab")

        composeTestRule.onAllNodesWithContentDescription(
            label = "Image of",
            substring = true,
            useUnmergedTree = true
        )[0].performClick()

        composeTestRule.onRoot().captureRoboImage("Detail-Screen")
        // TODO navigate back
        // TODO click and remove from favorites
    }
}