package org.komatsu.demo.client.configuration

import io.grpc.CallOptions
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.komatsu.demo.api.DemoServiceGrpcKt
import org.komatsu.demo.client.DemoClient
import org.komatsu.demo.client.utils.millis
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
@EnableConfigurationProperties(DemoClientConfigurationProperties::class)
open class DemoClientAutoConfiguration {
    @Bean
    open fun client(stub: DemoServiceGrpcKt.DemoServiceCoroutineStub) : DemoClient {
        return DemoClient(stub)
    }
    @Bean
    open fun stub(channel: ManagedChannel, callOptions: CallOptions) : DemoServiceGrpcKt.DemoServiceCoroutineStub {
        return DemoServiceGrpcKt.DemoServiceCoroutineStub(channel, callOptions)
    }
    @Bean
    open fun callOptions(properties: DemoClientConfigurationProperties) : CallOptions {
        return CallOptions.DEFAULT
            .withDeadlineAfter(properties.deadline.millis, TimeUnit.MILLISECONDS)
    }
    @Bean
    open fun channel(properties: DemoClientConfigurationProperties) : ManagedChannel {
        return ManagedChannelBuilder.forAddress(properties.host, properties.port)
            .usePlaintext()
            .build()
    }
}