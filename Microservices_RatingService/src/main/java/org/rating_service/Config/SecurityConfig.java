//package org.rating_service.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true) // Iski wajah se hi hum apne controllers mai PreAuthorize annotation use kr paate hain...
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
//        security
//                .authorizeHttpRequests((requests) -> requests
//                        .anyRequest()
//                        .authenticated())
//                .oauth2ResourceServer((auth) -> auth
//                        .jwt(Customizer.withDefaults()));
//
//        return security.build();
//    }
//}
