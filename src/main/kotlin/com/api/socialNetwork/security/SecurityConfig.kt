package com.api.socialNetwork.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.session.web.http.HeaderHttpSessionIdResolver
import org.springframework.session.web.http.HttpSessionIdResolver

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
class SecurityConfig {
    @Bean
    fun httpSessionIdResolver(): HttpSessionIdResolver {
        return HeaderHttpSessionIdResolver.xAuthToken()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun filterChain(http: HttpSecurity) : SecurityFilterChain {
        http
            .csrf().disable()
            .cors().and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/login", "/createNewUser")
            .permitAll().and()
            .authorizeRequests()
            .anyRequest()
            .authenticated().and()
            .httpBasic()

        return http.build()
    }
}
