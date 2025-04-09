package com.droidcon.flavorshub.roborazzi.screenshots

import androidx.test.core.app.ApplicationProvider
import com.droidcon.flavorshub.roborazzi.screenshots.testrules.FakeImageLoaderRule
import com.github.takahirom.roborazzi.DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH
import com.github.takahirom.roborazzi.ExperimentalRoborazziApi
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziComposeOptions
import com.github.takahirom.roborazzi.captureRoboImage
import com.github.takahirom.roborazzi.fontScale
import com.github.takahirom.roborazzi.locale
import com.github.takahirom.roborazzi.previewDevice
import com.github.takahirom.roborazzi.uiMode
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterValuesProvider
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestParameterInjector
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import sergio.sastre.composable.preview.scanner.android.AndroidComposablePreviewScanner
import sergio.sastre.composable.preview.scanner.android.AndroidPreviewInfo
import sergio.sastre.composable.preview.scanner.android.screenshotid.AndroidPreviewScreenshotIdBuilder
import sergio.sastre.composable.preview.scanner.core.preview.ComposablePreview

/**
 * Execute the following command for these screenshots
 * ./gradlew :roborazzi-tests:recordRoborazziDebug --tests 'CustomComposePreviewTest'
 */
class ComposablePreviewProvider : TestParameterValuesProvider() {
    private val cachedPreviews: List<ComposablePreview<AndroidPreviewInfo>> by lazy {
        AndroidComposablePreviewScanner()
            .scanPackageTrees("com.droidcon.flavorshub")
            .getPreviews()
    }

    override fun provideValues(context: Context?): List<ComposablePreview<AndroidPreviewInfo>>? =
        cachedPreviews
}

@RunWith(RobolectricTestParameterInjector::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel4)
class CustomComposePreviewTest(
    @TestParameter(valuesProvider = ComposablePreviewProvider::class)
    val preview: ComposablePreview<AndroidPreviewInfo>
) {

    fun screenshotNameFor(preview: ComposablePreview<AndroidPreviewInfo>): String =
        "$DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH/${AndroidPreviewScreenshotIdBuilder(preview).build()}.png"

    @get:Rule
    val fakeImageLoaderRule = FakeImageLoaderRule { ApplicationProvider.getApplicationContext() }

    @OptIn(ExperimentalRoborazziApi::class)
    @Test
    fun snapshotPreview() {
        captureRoboImage(
            filePath = screenshotNameFor(preview),
            roborazziComposeOptions = RoborazziComposeOptions {
                val previewInfo = preview.previewInfo
                previewDevice(previewInfo.device)
                uiMode(previewInfo.uiMode)
                locale(previewInfo.locale)
                fontScale(previewInfo.fontScale)
            }
        ) {
            preview()
        }
    }
}