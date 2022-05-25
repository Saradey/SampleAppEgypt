plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
android {
    compileSdk = rootProject.ext["compileSdkVersionApp"] as Int
    defaultConfig {
        minSdk = rootProject.ext["minSdkVersionApp"] as Int
        targetSdk = rootProject.ext["targetSdkVersionApp"] as Int
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
    //UI
    implementation(uiLibs.app.compat)
    implementation(uiLibs.material)
    implementation(uiLibs.constraint.layout)
}