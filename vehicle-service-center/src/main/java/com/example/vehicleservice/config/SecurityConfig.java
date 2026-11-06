package com.example.vehicleservice.config;
import org.springframework.context.annotation.*; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.web.SecurityFilterChain;
@Configuration public class SecurityConfig {
 @Bean SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{return http.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->auth.requestMatchers("/swagger-ui/**","/v3/api-docs/**","/actuator/health").permitAll().anyRequest().permitAll()).build();}
}
