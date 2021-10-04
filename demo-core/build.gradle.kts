val grpcVersion: String by properties
val springBootGrpcStarterVersion: String by properties

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation(project(":demo-api"))

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("net.devh:grpc-server-spring-boot-starter:$springBootGrpcStarterVersion")
    implementation("net.devh:grpc-client-spring-boot-starter:$springBootGrpcStarterVersion")

    testImplementation("io.grpc:grpc-testing:$grpcVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
