package com.jesus.productos.productos_crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class AppConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Productos CRUD")
                        .version("1.0")
                        .description("Backend desarrollado en Spring Boot 4 con PostgreSQL")
                        .contact(new Contact().name("Jesús Pereira").url("https://github.com/JesusPereira-ctrl")));
    }
}
