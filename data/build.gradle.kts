plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)

  id("com.google.devtools.ksp")
  id("dagger.hilt.android.plugin")
  id("kotlin-parcelize")
  kotlin("plugin.serialization") version "2.0.20"
}

android {
  namespace = "com.cbpark.data"
  compileSdk = 34

  defaultConfig {
    minSdk = 28

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)

  implementation(libs.symbol.processing.api)

  // Hilt Dagger
  implementation(libs.bundles.hilt.dagger)
  ksp(libs.bundles.hilt.dagger.compiler)
}