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
        maven(url = "https://jitpack.io")
    }
}

subprojects {
    // Tambahkan dependensi inorichi.injekt jika diperlukan di semua subproyek
    dependencies {
        implementation("com.github.inorichi.injekt:injekt-core:1.0.0") // Ganti dengan versi yang valid
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
