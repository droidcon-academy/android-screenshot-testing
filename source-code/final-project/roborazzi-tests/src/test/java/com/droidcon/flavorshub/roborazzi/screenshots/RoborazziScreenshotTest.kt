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
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import com.droidcon.flavorshub.FlavorshubActivity
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.RoborazziRule.Options
import com.github.takahirom.roborazzi.captureRoboImage

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(
    application = HiltTestApplication::class
)
class RoborazziScreenshotTest {
    @get:Rule(order = 0)
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

    @get:Rule(order = 1)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<FlavorshubActivity>()

    @get:Rule(order = 3)
    val roborazziRule =
        RoborazziRule(
            composeRule = composeTestRule,
            captureRoot = composeTestRule.onRoot(),
            options = Options(
                captureType = RoborazziRule.CaptureType.Gif(),
            )
        )

    @Test
    fun composable() {
        composeTestRule.waitForIdle()
        composeTestRule.onRoot().captureRoboImage("Home")
        composeTestRule.onNodeWithText("Favorites").performClick()
        composeTestRule.waitForIdle()

        composeTestRule.onRoot().captureRoboImage("Favorites")
    }
}