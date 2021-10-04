package org.komatsu.demo.core

import net.devh.boot.grpc.client.inject.GrpcClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.komatsu.demo.api.DemoServiceGrpc
import org.komatsu.demo.api.HelloRequest
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest(properties = [
    "grpc.server.inProcessName=test",
    "grpc.server.port=-1",
    "grpc.client.inProcess.address=in-process:test"
])
class SpringGrpcPilotApplicationTests {

    @GrpcClient("inProcess")
    lateinit var demoServiceClient: DemoServiceGrpc.DemoServiceBlockingStub

    @Test
    fun contextLoads() {
        val requestName = "Aleksei"
        val expectedPhrase = "Hello $requestName!"
        val response = demoServiceClient.sayHello(HelloRequest.newBuilder().setName(requestName).build()).message
            ?: throw IllegalStateException()
        assertEquals(expectedPhrase, response)
    }

}
