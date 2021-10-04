package org.komatsu.demo.core

import net.devh.boot.grpc.server.service.GrpcService
import org.komatsu.demo.api.DemoServiceGrpcKt
import org.komatsu.demo.api.HelloReply
import org.komatsu.demo.api.HelloRequest

@GrpcService
class DemoServiceImpl : DemoServiceGrpcKt.DemoServiceCoroutineImplBase() {
    override suspend fun sayHello(request: HelloRequest): HelloReply {
        return HelloReply.newBuilder().setMessage("Hello ${request.name}!").build();
    }
}