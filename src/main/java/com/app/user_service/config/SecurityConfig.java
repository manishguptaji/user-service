package com.app.user_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())  // new way to disable CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/user/**").permitAll()  // allow registration without login
                        .anyRequest().authenticated()  // protect other endpoints
                )
                .httpBasic(hBasic -> hBasic.disable());  // basic auth for other endpoints

        return http.build();
    }
}
