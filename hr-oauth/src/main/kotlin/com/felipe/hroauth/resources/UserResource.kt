package com.felipe.hroauth.resources

import com.felipe.hroauth.entities.User
import com.felipe.hroauth.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException

@RestController
@RequestMapping(value = ["/users"])
class UserResource {

    @Autowired
    private lateinit var service: UserService

    @GetMapping(value = ["/search"])
    fun findByEmail(@RequestParam email: String): ResponseEntity<User> {
        try {
            val user = service.findByEmail(email)

            return ResponseEntity.ok(user)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}