plugins {
    id("org.jetbrains.compose") version "1.0.1-rc2"
    id("org.kodein.library.mpp-with-android")
}

kodein {
    kotlin {
        common.main.dependencies {
            compileOnly(compose.runtime)
            api(project(":kodein-di"))
        }

        add(kodeinTargets.jvm.jvm) {
            target.setCompileClasspath()
        }

        add(kodeinTargets.jvm.android) {
            main.dependencies {
                api(project(":framework:android:kodein-di-framework-android-x"))
                api("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
            }
        }

        add(kodeinTargets.js.ir.js)
    }
}

kodeinUpload {
    name = "Kodein-DI-Framework-Compose"
    description = "Kodein-DI extensions for Jetpack / JetBrains Compose"
}