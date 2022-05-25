enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("coreLibs") {
            from(files("gradle/core-libs.versions.toml"))
        }
        create("uiLibs") {
            from(files("gradle/ui-libs.versions.toml"))
        }
        create("testingLibs") {
            from(files("gradle/testing-libs.versions.toml"))
        }
        create("androidLibs") {
            from(files("gradle/android-libs.versions.toml"))
        }
        create("devLibs") {
            from(files("gradle/dev-libs.versions.toml"))
        }
    }
}
include(":app")
include(":ui-kit")
include(":ui-sandbox")