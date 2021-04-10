// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("GradleDependency", "AndroidGradlePluginVersion")
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {

        val navVersion = "2.3.5"
        classpath("com.android.tools.build:gradle:7.0.0-alpha12")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}