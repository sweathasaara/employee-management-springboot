package com.employee.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        SecurityScheme basicAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("basic");

        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management System API")
                        .version("1.0")
                        .description("EMS APIs with Spring Security"))

                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))

                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("basicAuth", basicAuth));
    }
}