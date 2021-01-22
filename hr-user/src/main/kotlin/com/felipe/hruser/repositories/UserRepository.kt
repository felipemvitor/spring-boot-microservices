package com.felipe.hruser.repositories

import com.felipe.hruser.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String): Optional<User>
}