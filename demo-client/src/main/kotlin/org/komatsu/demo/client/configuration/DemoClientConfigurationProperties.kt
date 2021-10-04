package org.komatsu.demo.client.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import java.time.Duration

@ConfigurationProperties(prefix = "demo-client")
class DemoClientConfigurationProperties(
    val host: String,
    val port: Int,
    val deadline: Duration
)