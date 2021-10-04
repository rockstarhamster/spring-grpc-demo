rootProject.name = "spring-grpc-demo"

include("demo-api", "demo-core", "demo-client")

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val protobufPluginVersion: String by settings
    val springDependencyManagementVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.spring") version kotlinVersion
        id("com.google.protobuf") version protobufPluginVersion
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
    }
}
