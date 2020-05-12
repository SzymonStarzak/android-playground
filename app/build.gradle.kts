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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(project(Modules.featureAuth))
    implementation(project(Modules.featureHome))
    implementation(project(Modules.featureNotes))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.navigationUiKtx)

    implementation(Libs.dagger)
    kapt(Kapt.dagger)

    implementation(Libs.retrofit)
    implementation(Libs.okHttpLogging)
    implementation(Libs.retrofitMoshi)

    implementation(Libs.hawk)

    testImplementation(TestLibs.junit)
}
