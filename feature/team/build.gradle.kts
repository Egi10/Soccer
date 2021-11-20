import extensions.compose
import extensions.coroutine
import extensions.hilt
import extensions.navigation

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.Compose.compose
        kotlinCompilerVersion = Version.kotlin
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.Libraries.AndroidX.coreKtx)
    implementation(Dependencies.Libraries.AndroidX.appCompat)
    implementation(Dependencies.Libraries.AndroidX.material)
    implementation(Dependencies.Libraries.AndroidX.lifecycleRuntimeKtx)
    implementation(Dependencies.Libraries.AndroidX.constraintLayout)
    testImplementation(Dependencies.Libraries.Testing.junit)
    androidTestImplementation(Dependencies.Libraries.Testing.extJunit)
    androidTestImplementation(Dependencies.Libraries.Testing.espressoCore)

    implementation(Dependencies.Libraries.coil)

    compose()
    hilt()
    coroutine()
    navigation()

    implementation(project(Modules.domain))
}

kapt {
    correctErrorTypes = true
}