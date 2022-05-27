//TODO написать к релизу
fun getVersionName(): String = "1.0"

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = rootProject.ext["compileSdkVersionApp"] as Int
    defaultConfig {
        applicationId = "com.saradey.studio.ancient.egypt"
        minSdk = rootProject.ext["minSdkVersionApp"] as Int
        targetSdk = rootProject.ext["targetSdkVersionApp"] as Int
        versionCode = rootProject.ext["versionCodeApp"] as Int
        versionName = getVersionName()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    //AndroidX
    implementation(androidLibs.androidx.fragment.ktx)
    implementation(androidLibs.androidx.fragment)
    implementation(androidLibs.androidx.activity.ktx)
    implementation(androidLibs.androidx.core)
    implementation(androidLibs.androidx.workmanager)

    //Room
    implementation(androidLibs.androidx.room.runtime)
    kapt(androidLibs.androidx.room.compiler)
    implementation(androidLibs.androidx.room.ktx)
    testImplementation(androidLibs.androidx.room.testing)
    implementation(androidLibs.androidx.room.paging)

    //Dagger
    implementation(coreLibs.dagger.hilt.android)
    kapt(coreLibs.dagger.hilt.compiler)
    //For instrumentation tests
    androidTestImplementation(coreLibs.dagger.hilt.android.testing)
    kaptAndroidTest(coreLibs.dagger.hilt.compiler)
    //For local unit tests
    testImplementation(coreLibs.dagger.hilt.android.testing)
    kaptTest(coreLibs.dagger.hilt.compiler)

    //Coroutine
    implementation(coreLibs.kotlin.coroutines.core)
    implementation(coreLibs.kotlin.coroutines.android)
    testImplementation(coreLibs.kotlin.coroutines.test)

    //Network
    implementation(coreLibs.retrofit.core)
    implementation(coreLibs.retrofit.converter.gson)
    implementation(coreLibs.okhttp.core)
    implementation(coreLibs.okhttp.loggingInterceptor)
    testImplementation(coreLibs.gson)
    testImplementation(coreLibs.gson)

    //UI
    implementation(projects.uiKit)
    implementation(uiLibs.app.compat)
    implementation(uiLibs.material)
    implementation(uiLibs.constraint.layout)
    implementation(uiLibs.androidx.recyclerview)
    implementation(uiLibs.glide.core)
    implementation(uiLibs.viewBindingPropertyDelegate)
    implementation(uiLibs.paging.runtime)
    testImplementation(uiLibs.paging.common)

    //Quality
    debugImplementation(devLibs.chucker)
    debugImplementation(devLibs.leak.canary)

    //testing
    testImplementation(testingLibs.test.junit)
    androidTestImplementation(testingLibs.test.junit.ext)
    androidTestImplementation(testingLibs.test.espresso.core)
}