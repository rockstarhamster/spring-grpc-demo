package org.komatsu.demo.client.utils

import java.time.Duration

val Duration.millis: Long
    get() = this.seconds / 1000