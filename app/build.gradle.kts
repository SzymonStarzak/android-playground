plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}
android {
    compileSdkVersion(Androids.compileSdk)
    buildToolsVersion = Androids.buildToolsVersion
    defaultConfig {
        applicationId = Androids.applicationId
        minSdkVersion(Androids.minSdk)
        targetSdkVersion(Androids.targetSdk)
        versionCode = Androids.versionCode
        versionName = Androids.versionName
        testInstrumentationRunner = Androids.testInstrumentationRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(Modules.featureHome))
    implementation(project(Modules.featureLogin))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.constraintLayout)
    implementation(Libs.navigationFragmentKtx)
    implementation(Libs.navigationUiKtx)
    implementation(Libs.dagger)
    kapt(Kapt.dagger)
    testImplementation(TestLibs.junit)
}
