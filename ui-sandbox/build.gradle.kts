plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    compileSdk = rootProject.ext["compileSdkVersionApp"] as Int
    defaultConfig {
        applicationId = "com.saradey.studio.ancient.egypt.ui_sandbox"
        minSdk =  rootProject.ext["minSdkVersionApp"] as Int
        targetSdk = rootProject.ext["targetSdkVersionApp"] as Int
        versionCode =  rootProject.ext["versionCodeApp"] as Int
        versionName = "1.0"
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
dependencies {
    //UI
    implementation(projects.uiKit)
    implementation(uiLibs.app.compat)
    implementation(uiLibs.material)
    implementation(uiLibs.constraint.layout)
    implementation(uiLibs.viewBindingPropertyDelegate)
}