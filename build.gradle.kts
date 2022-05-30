plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

buildscript {
    extra.apply {
        set("targetSdkVersionApp", 32)
        set("compileSdkVersionApp", 32)
        set("minSdkVersionApp", 23)
        set("versionCodeApp", 1)
    }
    dependencies {
        // other plugins...
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
    }
}