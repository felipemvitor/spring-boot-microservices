package com.felipe.hrapigatewayzuul.config

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore

@RefreshScope
@Configuration
class AppConfig {

    @Value("\${jwt.secret}")
    private var jwtSecret: String = ""

    @Bean
    open fun jwtAccessTokenConverter(): JwtAccessTokenConverter {
        val tokenConverter = JwtAccessTokenConverter()
        tokenConverter.setSigningKey(jwtSecret)

        return tokenConverter
    }

    @Bean
    open fun tokenStore(): JwtTokenStore {
        return JwtTokenStore(jwtAccessTokenConverter())
    }
}