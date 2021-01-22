package com.felipe.hroauth.feignclients

import com.felipe.hroauth.entities.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Component
@FeignClient(name="hr-user", path = "/users")
interface UserFeignClient {

    @GetMapping(value = ["/search"])
    fun findByEmail(@RequestParam email: String): ResponseEntity<User>
}