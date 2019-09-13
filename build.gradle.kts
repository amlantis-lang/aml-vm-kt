import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the application plugin to add support for building a CLI application.
    application

    // Apply the Kotlin JVM plugin to add support for Kotlin.
    kotlin("jvm") version "1.3.50"
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        verbose = true
        apiVersion = "1.3"
        languageVersion = "1.3"
        jvmTarget = "12"
        noReflect = false
        noStdlib = false
    }
}

dependencies {
    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    // Use the Kotlin test library.
    testImplementation(kotlin("test"))

    // Use the Kotlin JUnit integration.
    testImplementation(kotlin("test-junit"))
}

application {
    // Define the main class for the application
    mainClassName = "org.aml.vm.VmKt"
}
