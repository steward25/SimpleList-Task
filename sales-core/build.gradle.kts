plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.dokka)
}

android {
    namespace = "com.stewardapostol.sales_core"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24

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
}

tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
    dokkaSourceSets {
        // Instead of named("main"), we configure all discovered sets
        configureEach {
            // Force Dokka to look at the Android source directory
            sourceRoots.from(file("src/main/java"))

            moduleName.set("Sales Core Module")

            // This ensures public classes are documented even if they have no KDoc yet
            reportUndocumented.set(true)

            if (file("README.md").exists()) {
                includes.from("README.md")
            }
        }
    }
}

dependencies {
    // Shared Logic Essentials
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}