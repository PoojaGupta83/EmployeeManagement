package com.employee.employeemanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management System API")
                        .version("1.0")
                        .description("REST APIs for managing employees in the organization")
                        .contact(new Contact()
                                .name("Pooja Gupta")
                                .url("https://github.com/your-github")
                                .email("pooja@example.com")
                        )
                );
    }
}
