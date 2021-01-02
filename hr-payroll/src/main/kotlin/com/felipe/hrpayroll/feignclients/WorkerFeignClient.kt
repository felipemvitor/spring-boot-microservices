package com.felipe.hrpayroll.feignclients

import com.felipe.hrpayroll.entities.Worker
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
interface WorkerFeignClient {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Worker>
}