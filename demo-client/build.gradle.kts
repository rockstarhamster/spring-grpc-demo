val springBootGrpcStarterVersion: String by properties

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":demo-api"))
    implementation("net.devh:grpc-client-spring-boot-starter:$springBootGrpcStarterVersion")
}