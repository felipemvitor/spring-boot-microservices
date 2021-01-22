package com.felipe.hroauth.services

import com.felipe.hroauth.entities.User
import com.felipe.hroauth.feignclients.UserFeignClient
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class UserService {

    companion object {
        val logger = LoggerFactory.getLogger(UserService::class.java)
    }

    @Autowired
    private lateinit var userFeignClient: UserFeignClient

    fun findByEmail(email: String): User {
        val user = userFeignClient.findByEmail(email).body
        if (user == null) {
            logger.info("Email not found: $email")
            throw IllegalArgumentException("Email not found")
        }
        logger.info("Email found: $email")
        return user
    }
}