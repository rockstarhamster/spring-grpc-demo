import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val projectGroup: String by properties
val projectVersion: String by properties
val jvmTargetVersion: String by properties

plugins {
    kotlin("jvm")
}

subprojects {
    group = projectGroup
    version = projectVersion

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = jvmTargetVersion
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

