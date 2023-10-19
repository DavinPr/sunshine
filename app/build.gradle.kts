import java.util.Date
import java.text.SimpleDateFormat


plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
}

private val majorVersion = 1
private val minorVersion = 0
private val patchVersion = 0
private val preRelease = "alpha"
private val release = "release"

android {
    compileSdk = 32
    buildToolsVersion = "32.0.0"

    defaultConfig {
        applicationId = "com.adityadavin.sunshine"
        minSdk = 21
        targetSdk = 32
        versionCode = generateVersionCode()
        versionName = generateVersionName()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    flavorDimensions ("env")
    productFlavors {
        create("dev") {
            dimension = "env"
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "API_KEY", "\"6d4359e131e2493dedd72daec5c5229a\"")
            buildConfigField("String", "IMAGE_URL", "\"https://image.tmdb.org/t/p/w500\"")
            versionNameSuffix = "-dev"
        }
        create("production") {
            dimension = "env"
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "API_KEY", "\"6d4359e131e2493dedd72daec5c5229a\"")
            buildConfigField("String", "IMAGE_URL", "\"https://image.tmdb.org/t/p/w500\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    //Internal CodeBase
    implementation(project(":sunshine"))
}

fun generateVersionCode(): Int {
    return majorVersion * 10000 + minorVersion * 100 + patchVersion
}

fun generateVersionName(): String {
    var versionName = "$majorVersion.$minorVersion.$patchVersion"
    if (preRelease.isNotEmpty()) {
        versionName = "$versionName-$preRelease"
    }
    return versionName
}

fun getBuildTime(): String {
    return SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Date())
}