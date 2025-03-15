package com.example.rest_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection for Actuator endpoints
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // Allow public API access
                .requestMatchers("/actuator/**").permitAll() // Allow unrestricted Actuator access
                .anyRequest().authenticated()
            );

        return http.build();
    }
}

// package com.example.rest_api.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/login").permitAll() // Allow /login publicly
//                 .anyRequest().authenticated() // Other requests need authentication
//             )
//             .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity in testing
//             .httpBasic();  // Enable basic authentication for testing

//         return http.build();
//     }

//     @Bean
//     public UserDetailsService userDetailsService() {
//         // Define the default user for testing
//         return username -> {
//             if ("admin".equals(username)) {
//                 return User.builder()
//                     .username("admin")
//                     .password(passwordEncoder().encode("admin"))
//                     .roles("ADMIN")
//                     .build();
//             } else {
//                 throw new RuntimeException("User not found");
//             }
//         };
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();  // Password encoder for authentication
//     }
// }
