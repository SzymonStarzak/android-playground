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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    api(project(Modules.core))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.constraintLayout)
    implementation(Libs.navigationFragmentKtx)
    implementation(Libs.navigationUiKtx)

    // DI
    implementation(Libs.dagger)
    kapt(Kapt.dagger)

    // Coroutines
    implementation(Libs.coroutines)
    implementation(Libs.coroutinesAndroid)

    // Persistence
    implementation(Libs.room)
    implementation(Libs.roomKtx)
    kapt(Kapt.room)

    // Network
    implementation(Libs.retrofit)
    implementation(Libs.retrofitMoshi)
    implementation(Libs.okHttpLogging)
    implementation(Libs.moshi)
    kapt(Kapt.moshi)

    //Tests
    testImplementation(TestLibs.junit)
}