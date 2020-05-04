object Androids {
    const val compileSdk = 29
    const val minSdk = 23
    const val targetSdk = 29
    const val versionCode = 1
    const val buildToolsVersion = "29.0.3"
    const val versionName = "1.0"
    const val applicationId = "apps.sstarzak.playground"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val appcompat = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val coreKtx = "1.2.0"
    const val coroutines = "1.3.5"
    const val dagger = "2.25.2"
    const val gradle = "3.6.2"
    const val junit = "4.12"
    const val kotlin = "1.3.71"
    const val lifecycle = "2.2.0"
    const val material = "1.1.0"
    const val moshi = "1.9.2"
    const val navigationKtx = "2.2.1"
    const val retrofit = "2.8.1"
    const val room = "2.2.5"
}

object ClassPath {
    const val kotlin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Libs {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationKtx}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationKtx}"

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
}

object Kapt {
    const val dagger = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val moshi = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val room = "androidx.room:room-compiler:${Versions.room}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
}

object AndroidTestLibs