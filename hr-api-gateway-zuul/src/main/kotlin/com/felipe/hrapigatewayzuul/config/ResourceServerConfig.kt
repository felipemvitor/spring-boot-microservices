package com.felipe.hrapigatewayzuul.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
@EnableResourceServer
class ResourceServerConfig : ResourceServerConfigurerAdapter() {

    companion object {
        private const val ROLE_OPERATOR = "OPERATOR"
        private const val ROLE_ADMIN = "ADMIN"
        private val ROLES = arrayOf(ROLE_OPERATOR, ROLE_ADMIN)

        private val PUBLIC = arrayOf("/hr-oauth/oauth/token")
        private val OPERATOR = arrayOf("/hr-worker/**")
        private val ADMIN =
            arrayOf("/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**")
    }

    @Autowired
    private lateinit var tokenStore: JwtTokenStore

    override fun configure(resources: ResourceServerSecurityConfigurer?) {
        resources?.tokenStore(tokenStore)
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
            ?.antMatchers(*PUBLIC)?.permitAll()
            ?.antMatchers(HttpMethod.GET, *OPERATOR)?.hasAnyRole(*ROLES)
            ?.antMatchers(*ADMIN)?.hasRole(ROLE_ADMIN)
            ?.anyRequest()?.authenticated()

        http?.cors()?.configurationSource(corsConfigurationSource())
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfig = CorsConfiguration()
        corsConfig.allowedOrigins = listOf("*")
        corsConfig.allowedMethods = listOf("POST", "GET", "PUT", "PATCH", "DELETE")
        corsConfig.allowCredentials = true
        corsConfig.allowedHeaders = listOf("Authorization", "Content-Type")

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig)

        return source
    }

    @Bean
    fun corsFilter(): FilterRegistrationBean<CorsFilter> {
        val bean = FilterRegistrationBean(CorsFilter(corsConfigurationSource()))

        bean.order = Ordered.HIGHEST_PRECEDENCE

        return bean
    }
}