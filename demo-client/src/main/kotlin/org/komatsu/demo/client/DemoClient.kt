package org.komatsu.demo.client

import org.komatsu.demo.api.DemoServiceGrpcKt
import org.komatsu.demo.api.HelloReply
import org.komatsu.demo.api.HelloRequest

class DemoClient(
    private val stub: DemoServiceGrpcKt.DemoServiceCoroutineStub
) : DemoServiceGrpcKt.DemoServiceCoroutineImplBase() {
    override suspend fun sayHello(request: HelloRequest): HelloReply {
        return stub.sayHello(request)
    }
}