package com.droidcon.flavorshub.roborazzi.screenshots

import androidx.compose.material3.Text
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class RoborazziScreenshotTest {
        //@get:Rule
        //val composeTestRule = createAndroidComposeRule<ComponentActivity>()

        /*
        @get:Rule
        val roborazziRule =
            RoborazziRule(
                composeRule = composeTestRule,
                captureRoot = composeTestRule.onRoot(),
                options = Options(
                    captureType = RoborazziRule.CaptureType.Gif(),
                )
            )

         */

        @Test
        fun composable() {
            /*
            composeTestRule.setContent {
                Text("Hello")
            }

             */

            captureRoboImage("screenshot.png") {
                Text("Hello")
            }

        }
}