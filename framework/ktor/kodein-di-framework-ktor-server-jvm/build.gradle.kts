val ktorVersion = "1.5.2"
val logbackVersion = "1.2.3"

plugins {
    id("org.kodein.library.jvm")
}

repositories {
    maven("https://kotlin.bintray.com/ktor")
}

dependencies {
    fun ktor(module: String = "", version: String = ktorVersion) = "io.ktor:ktor$module:$version"

    api(project(":kodein-di"))
    implementation(ktor())
    implementation(ktor("-server-core"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kodeinVersions.kotlin}") // TODO remove with Ktor built on 1.5
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(ktor("-server-tests"))
}

kodeinUpload {
    name = "Kodein-DI-Framework-Ktor"
    description = "Kodein-DI Kotlin classes & extensions for Ktor."
}