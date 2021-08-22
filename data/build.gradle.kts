plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Coroutine
    implementation(Dependencies.Libraries.Coroutines.core)
    implementation(Dependencies.Libraries.Coroutines.android)
    testImplementation(Dependencies.Libraries.Coroutines.test)
    // Hilt
    implementation(Dependencies.Libraries.Hilt.android)
    kapt(Dependencies.Libraries.Hilt.compiler)
    testImplementation(Dependencies.Libraries.Hilt.testing)
    kaptTest(Dependencies.Libraries.Hilt.compiler)
    // Retrofit
    implementation(Dependencies.Libraries.Retrofit.retrofit)
    implementation(Dependencies.Libraries.Retrofit.converterMoshi)
    // Module Domain
    implementation(project(Modules.domain))
}