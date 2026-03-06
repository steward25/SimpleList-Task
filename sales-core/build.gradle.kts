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
        // This targets the standard Android source sets created by Dokka
        configureEach {
            moduleName.set("Sales Core Module")

            // Check for README in the module directory
            if (file("README.md").exists()) {
                includes.from("README.md")
            }

            // Helpful if you want to skip documenting internal/test code
            skipEmptyPackages.set(true)
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