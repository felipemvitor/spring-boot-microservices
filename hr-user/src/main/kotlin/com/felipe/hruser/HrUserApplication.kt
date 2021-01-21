package com.felipe.hruser

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class HrUserApplication

fun main(args: Array<String>) {
    runApplication<HrUserApplication>(*args)
}
