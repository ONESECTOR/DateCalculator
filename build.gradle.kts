buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0")
        classpath("com.google.gms:google-services:4.3.10")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.1")
    }
}

plugins {
    id("com.android.application") version "7.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
}

val clean by tasks.creating(Delete::class) {
    delete = setOf(rootProject.buildDir)
}
