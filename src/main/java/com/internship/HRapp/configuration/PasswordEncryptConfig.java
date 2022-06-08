package com.internship.HRapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptConfig {

    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(10);
    }

//    @Bean
//    public JwtUtil jwtTokenUtilBean() {
//        return new JwtUtil();
//    }
}