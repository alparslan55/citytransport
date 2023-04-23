@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.firebase.crashlytics")
    id("com.google.gms.google-services")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = NAMESPACE
    compileSdk = TARGET_SDK

    defaultConfig {
        applicationId = APPLICATION_ID
        minSdk = MIN_SDK
        targetSdk = TARGET_SDK
        versionCode = VERSION_CODE
        versionName = VERSION_NAME

        testInstrumentationRunner = TEST_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Multidex
    implementation("androidx.multidex:multidex:2.0.1")

    // Dependency injection
    implementation("com.google.dagger:hilt-android:2.44")
    implementation("androidx.hilt:hilt-work:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")
    // When using Kotlin.
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    annotationProcessor("androidx.hilt:hilt-compiler:1.0.0")

    // Room
    implementation("androidx.room:room-runtime:2.5.1")
    annotationProcessor("androidx.room:room-compiler:2.5.1")

    // Worker
    implementation("androidx.work:work-runtime-ktx:2.8.1")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    // Play Services Coroutine Extensions
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")

    // Firebase
    implementation("com.google.firebase:firebase-messaging-ktx:23.1.2")
    implementation("com.google.firebase:firebase-crashlytics-ktx:18.3.6")

    // Map
    implementation("com.google.maps.android:maps-compose:2.11.1")
    implementation("com.google.android.gms:play-services-maps:18.1.0")

    // Security
    implementation("androidx.security:security-crypto:1.1.0-alpha05")

    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation("androidx.compose.ui:ui:1.4.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.2")
    implementation("androidx.compose.material3:material3:1.1.0-beta02")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.2")
    debugImplementation("androidx.compose.ui:ui-tooling:1.4.2")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.2")
}