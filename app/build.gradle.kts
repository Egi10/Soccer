import extensions.compose
import extensions.coroutine
import extensions.hilt

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
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
    implementation(Dependencies.Libraries.AndroidX.constraintLayout)
    testImplementation(Dependencies.Libraries.Testing.junit)
    androidTestImplementation(Dependencies.Libraries.Testing.extJunit)
    androidTestImplementation(Dependencies.Libraries.Testing.espressoCore)
    compose()
    hilt()
    coroutine()
    // Retrofit
    implementation(Dependencies.Libraries.Retrofit.retrofit)
    // Module
    implementation(project(Modules.data))
    implementation(project(Modules.domain))
    // Feature
    implementation(project(Modules.Feature.home))
}

kapt {
    correctErrorTypes = true
}