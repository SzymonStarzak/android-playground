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
    const val gradle = "3.6.2"
    const val kotlin = "1.3.71"
    const val appcompat = "1.1.0"
    const val junit = "4.12"
    const val dagger = "2.25.2"
    const val coreKtx = "1.2.0"
    const val navigation = "2.2.1"
    const val material = "1.1.0"
    const val constraintLayout = "1.1.3"
}

object ClassPath {
    const val kotlin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val material = "com.google.android.material:material:${Versions.material}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"

}

object Kapt {
    const val dagger = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val dagger_android =
        "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
}

object AndroidTestLibs