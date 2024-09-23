// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.compose.compiler) apply false
  alias(libs.plugins.android.library) apply false
  id("com.google.devtools.ksp") version "2.0.10-1.0.24" apply false
}

buildscript {
  dependencies {
    classpath(libs.hilt.android.gradle.plugin)
  }
}