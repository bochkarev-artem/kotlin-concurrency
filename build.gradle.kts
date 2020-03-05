import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("plugin.serialization") version "1.3.61"
    kotlin("jvm") version "1.3.61"
}

version="1.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.14.0")
    testImplementation("junit:junit:4.12")
}
repositories {
    mavenCentral()
    jcenter()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
    freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.Experimental"
}