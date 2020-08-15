import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the application plugin to add support for building a CLI application.
    application

    // Apply the Kotlin JVM plugin to add support for Kotlin.
    kotlin("jvm") version "1.3.72"

    kotlin("kapt") version "1.3.72"
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
        jvmTarget = "13"
        noReflect = false
        noStdlib = false
        includeRuntime = true
        freeCompilerArgs = listOf("-Xinline-classes")
    }
}

dependencies {
    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("io.arrow-kt:arrow-core:0.10.5")
    implementation("io.arrow-kt:arrow-syntax:0.10.5")
    implementation("com.squareup.okio:okio:2.7.0")
    implementation("com.ibm.icu:icu4j:67.1")

    kapt("io.arrow-kt:arrow-meta:0.10.5")

    // Use the Kotlin test library.
    testImplementation(kotlin("test"))

    // Use the Kotlin JUnit integration.
    testImplementation(kotlin("test-junit"))

    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("com.google.truth.extensions:truth-java8-extension:1.0.1")
}

application {
    // Define the main class for the application
    mainClassName = "org.aml.vm.VmKt"
}
