package com.felipe.hrapigatewayzuul.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore

@Configuration
class AppConfig {

    @Bean
    open fun jwtAccessTokenConverter(): JwtAccessTokenConverter {
        val tokenConverter = JwtAccessTokenConverter()
        tokenConverter.setSigningKey("MY-SECRET-KEY")

        return tokenConverter
    }

    @Bean
    open fun tokenStore(): JwtTokenStore {
        return JwtTokenStore(jwtAccessTokenConverter())
    }
}