package com.droidcon.flavorshub.paparazzi.screenshots.testRules

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import coil3.ColorImage
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.annotation.DelicateCoilApi
import coil3.annotation.ExperimentalCoilApi
import coil3.test.FakeImageLoaderEngine
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import java.util.concurrent.atomic.AtomicInteger

class FakeImageLoaderRule(private val context: () -> Context) : TestWatcher() {
    @OptIn(ExperimentalCoilApi::class, DelicateCoilApi::class)
    override fun starting(description: Description?) {
        super.starting(description)
        val requestCounter = AtomicInteger(0)
        val engine = FakeImageLoaderEngine.Builder()
            .intercept(
                { request -> requestCounter.getAndIncrement() == 0 },
                ColorImage(Color.Red.toArgb())
            )
            .intercept({ request -> true }, ColorImage(Color.Green.toArgb()))
            .build()
        val imageLoader = ImageLoader.Builder(context())
            .components { add(engine) }
            .build()
        SingletonImageLoader.setUnsafe(imageLoader)
    }
}