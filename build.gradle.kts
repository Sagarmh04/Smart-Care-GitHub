
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}

buildscript {
    repositories {
        google() // Add this line
        mavenCentral() // Add this line
    }
    dependencies {
        classpath("com.google.gms:google-services:4.3.15") // Use the latest version
    }

}