object Dependencies {
    object BuildPlugins {
        const val android = "com.android.tools.build:gradle:${Version.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
    }

    object Libraries {
        object Testing {
            const val junit = "junit:junit:${Version.Testing.junit}"
            const val extJunit = "androidx.test.ext:junit:${Version.Testing.extJunit}"
            const val espressoCore =
                "androidx.test.espresso:espresso-core:${Version.Testing.espressoCore}"
        }

        object AndroidX {
            const val coreKtx = "androidx.core:core-ktx:${Version.AndroidX.ktx}"
            const val appCompat = "androidx.appcompat:appcompat:${Version.AndroidX.appCompat}"
            const val material = "com.google.android.material:material:${Version.material}"
            const val constraintLayout =
                "androidx.constraintlayout:constraintlayout:${Version.AndroidX.constraintLayout}"
        }

        object Retrofit {
            const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
            const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
        }

        object Coroutines {
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
            const val core =
                "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
        }

        object Hilt {
            const val android = "com.google.dagger:hilt-android:${Version.hilt}"
            const val compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
            const val testing = "com.google.dagger:hilt-android-testing:${Version.hilt}"
        }
    }
}