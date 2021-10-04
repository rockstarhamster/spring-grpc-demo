import com.google.protobuf.gradle.*

val grpcVersion: String by properties
val grpcktVersion: String by properties
val jakartaVersion: String by properties
val protobufVersion: String by properties

plugins {
    id("idea")
    kotlin("jvm")
    id("com.google.protobuf")
}

repositories {
    mavenCentral()
}

dependencies {
    api("io.grpc:grpc-protobuf:$grpcVersion")
    api("io.grpc:grpc-kotlin-stub:$grpcktVersion")

    implementation("io.grpc:grpc-stub:$grpcVersion")

    compileOnly("jakarta.annotation:jakarta.annotation-api:$jakartaVersion")
}

//can be our own gradle plugin
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }
    generatedFilesBaseDir = "$projectDir/src/generated"
    tasks.withType<Delete> {
        delete(generatedFilesBaseDir)
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpcktVersion:jdk7@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}

idea {
    module {
        sourceDirs.plusAssign(file("${projectDir}/src/generated/main/java"));
        sourceDirs.plusAssign(file("${projectDir}/src/generated/main/grpc"));
    }
}