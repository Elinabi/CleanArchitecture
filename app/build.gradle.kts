plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //Kapt
    kotlin("kapt")
    //Hilt
    id("com.google.dagger.hilt.android")

}
android {
    namespace = "com.example.cleanarchitecture"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.cleanarchitecture"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles( getDefaultProguardFile ("proguard-android-optimize.txt"),
            "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

// Core
    implementation("androidx.core:core-ktx:1.10.1")
// AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")
// Material Design
    implementation("com.google.android.material:material:1.9.0")
//Ui Components
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

//Live Cycle
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Fragment
    val fragment_version = "1.5.5"
    // noinspection GradleDependency
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    // Hilt
    val hilt_version = "2.45"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    // Paging 3
    val paging_version = "3.1.1"
    implementation("androidx.paging:paging-runtime:$paging_version")

    // Presentation
    implementation(project(":presentation"))

    // Domain
    implementation(project(":domain"))

    // Data
    implementation(project(":data"))

}