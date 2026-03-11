package com.employee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/leave/apply").hasRole("EMPLOYEE")
                        .requestMatchers("/leave/*/approve").hasRole("MANAGER")
                        .requestMatchers("/employees/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )

                .httpBasic(Customizer.withDefaults())

                .exceptionHandling(exception -> exception

                        // 401 ERROR
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(401);
                            response.setContentType("application/json");
                            response.getWriter().write(
                                    "{ \"error\": \"Unauthorized - Authentication required\" }"
                            );
                        })

                        // 403 ERROR
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setStatus(403);
                            response.setContentType("application/json");
                            response.getWriter().write(
                                    "{ \"error\": \"Forbidden - You do not have permission to perform this action\" }"
                            );
                        })
                );

        return http.build();
    }
}