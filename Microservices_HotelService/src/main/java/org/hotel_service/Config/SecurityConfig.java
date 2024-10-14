//package org.hotel_service.Config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
//        security.authorizeHttpRequests((requests) -> requests
//                .anyRequest()
//                .authenticated())
//                .oauth2ResourceServer((auth) -> auth
//                        .jwt(Customizer.withDefaults()));
//
//        return security.build();
//    }
//}
