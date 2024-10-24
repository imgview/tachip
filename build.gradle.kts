buildscript {
    repositories {
        mavenCentral()
        google()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(libs.gradle.agp)
        classpath(libs.gradle.kotlin)
        classpath(libs.gradle.serialization)
        classpath(libs.gradle.kotlinter)
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven(url = "https://jitpack.io") // Menambahkan repositori JitPack di sini
    }
}

dependencies {
    implementation("com.github.imgview:tachip:1.0.0") // Ganti '1.0.0' dengan versi yang sesuai
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory.asFile.get())
}