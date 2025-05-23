package com.evalpro.EvalPro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/api/login", "/api/login/").permitAll()
                .requestMatchers(HttpMethod.OPTIONS, "/api/login", "/api/login/").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin().disable() // Desactiva formulario login por defecto
            .httpBasic().disable(); // Desactiva HTTP Basic
        return http.build();
    }
}