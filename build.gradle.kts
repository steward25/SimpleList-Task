// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false

    // Kotlin 2.0 Compose Compiler plugin
    alias(libs.plugins.kotlin.compose) apply false

    // Documentation plugin for KDoc
    alias(libs.plugins.dokka) apply false
}