plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Androids.compileSdk)
    buildToolsVersion = Androids.buildToolsVersion
    defaultConfig {
        minSdkVersion(Androids.minSdk)
        targetSdkVersion(Androids.targetSdk)
        versionCode = Androids.versionCode
        versionName = Androids.versionName
        testInstrumentationRunner = Androids.testInstrumentationRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.appcompat)
    testImplementation(TestLibs.junit)
}