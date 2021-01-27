package com.felipe.hroauth.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore

@Configuration
@EnableAuthorizationServer
open class AuthorizationServerConfig : AuthorizationServerConfigurerAdapter() {

    @Autowired
    private lateinit var passwordEncoder: BCryptPasswordEncoder

    @Autowired
    private lateinit var accessTokenConverter: JwtAccessTokenConverter

    @Autowired
    private lateinit var tokenStore: JwtTokenStore

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager


    override fun configure(security: AuthorizationServerSecurityConfigurer?) {
        security?.tokenKeyAccess("permitAll()")?.checkTokenAccess("isAuthenticated()")
    }

    override fun configure(clients: ClientDetailsServiceConfigurer?) {
        clients?.inMemory()
            ?.withClient("myappname123")
            ?.secret(passwordEncoder.encode("myappsecret123"))
            ?.scopes("read", "write")
            ?.authorizedGrantTypes("password")
            ?.accessTokenValiditySeconds(86400)
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer?) {
        endpoints
            ?.authenticationManager(authenticationManager)
            ?.tokenStore(tokenStore)
            ?.accessTokenConverter(accessTokenConverter)
    }
}