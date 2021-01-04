package com.felipe.hrconfigserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@EnableConfigServer
@SpringBootApplication
class HrConfigServerApplication

fun main(args: Array<String>) {
    runApplication<HrConfigServerApplication>(*args)
}
