plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.screenshot)
}

android {
    namespace = "com.droidcon.flavorshub.composepreview"
    compileSdk = 35

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

dependencies {
    screenshotTestImplementation(project(":ui"))

    screenshotTestImplementation(platform("androidx.compose:compose-bom:2023.06.01"))
    screenshotTestImplementation("androidx.compose.ui:ui")
    screenshotTestImplementation("androidx.compose.ui:ui-graphics")
    screenshotTestImplementation("androidx.compose.ui:ui-tooling-preview")
    screenshotTestImplementation("androidx.compose.material3:material3")
    screenshotTestImplementation("androidx.compose.material3:material3")
    screenshotTestImplementation(libs.coil.compose)
    screenshotTestImplementation(libs.coil.network)
    screenshotTestImplementation(libs.androidx.core.ktx)
    screenshotTestImplementation(libs.androidx.lifecycle.runtime.ktx)
    screenshotTestImplementation(libs.androidx.activity.compose)
    screenshotTestImplementation(libs.kotlinx.collections.immutable.jvm)
    screenshotTestImplementation(libs.androidx.navigation.compose)
    screenshotTestImplementation(libs.lifecycle.viewmodel.compose)
    screenshotTestImplementation(libs.lifecycle.runtime.compose)

    screenshotTestImplementation(libs.androidx.core.ktx)
    screenshotTestImplementation(libs.androidx.appcompat)
    screenshotTestImplementation(libs.material)
    screenshotTestImplementation(libs.androidx.ui.tooling.preview)
}