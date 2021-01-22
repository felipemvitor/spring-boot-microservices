package com.felipe.hruser.resources

import com.felipe.hruser.entities.User
import com.felipe.hruser.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/users"])
class UserResources {


    @Autowired
    private lateinit var userRepository: UserRepository

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userRepository.findById(id).get()

        return ResponseEntity.ok(user)
    }

    @GetMapping(value = ["/search"])
    fun findById(@RequestParam email: String): ResponseEntity<User> {
        val user = userRepository.findByEmail(email).get()

        return ResponseEntity.ok(user)
    }
}