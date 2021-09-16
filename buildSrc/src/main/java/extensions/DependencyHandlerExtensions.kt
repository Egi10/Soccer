package extensions

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.coroutine() {
    implementation(Dependencies.Libraries.Coroutines.core)
    implementation(Dependencies.Libraries.Coroutines.android)
    testImplementation(Dependencies.Libraries.Coroutines.test)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.Libraries.Hilt.android)
    kapt(Dependencies.Libraries.Hilt.compiler)
    testImplementation(Dependencies.Libraries.Hilt.testing)
    kaptTest(Dependencies.Libraries.Hilt.compiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.Libraries.Retrofit.retrofit)
    implementation(Dependencies.Libraries.Retrofit.converterMoshi)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.Libraries.Compose.composeUi)
    implementation(Dependencies.Libraries.Compose.material)
    implementation(Dependencies.Libraries.Compose.uiToolingPreview)
    implementation(Dependencies.Libraries.Compose.activityCompose)
    implementation(Dependencies.Libraries.Compose.uiTestJunit4)
    implementation(Dependencies.Libraries.Compose.uiTooling)
}

fun DependencyHandler.implementation(dependencyNotation: String) {
    add("implementation", dependencyNotation)
}

fun DependencyHandler.kapt(dependencyNotation: String) {
    add("kapt", dependencyNotation)
}

fun DependencyHandler.testImplementation(dependencyNotation: String) {
    add("testImplementation", dependencyNotation)
}

fun DependencyHandler.kaptTest(dependencyNotation: String) {
    add("kaptTest", dependencyNotation)
}