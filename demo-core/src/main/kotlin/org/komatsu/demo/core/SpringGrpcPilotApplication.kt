package org.komatsu.demo.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringGrpcPilotApplication

fun main(args: Array<String>) {
    runApplication<SpringGrpcPilotApplication>(*args)
}
