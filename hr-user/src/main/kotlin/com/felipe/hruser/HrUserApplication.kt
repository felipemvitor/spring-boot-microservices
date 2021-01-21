package com.felipe.hruser

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@EnableEurekaClient
@SpringBootApplication
class HrUserApplication : CommandLineRunner {

    @Autowired
    private lateinit var passwordEncoder: BCryptPasswordEncoder

    override fun run(vararg args: String?) {
        println("BCRYPT = ${passwordEncoder.encode("123456")}")
    }
}

fun main(args: Array<String>) {
    runApplication<HrUserApplication>(*args)
}
