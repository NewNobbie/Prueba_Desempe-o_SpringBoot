package com.riwi.Multimedia.content.management.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Jimmy Flórez",
                        url = "https://github.com/NewNobbie",
                        email = "florezs043@gmail.com"
                ),
                title = "Documentation: Multimedia-content-management",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080/api/v1")
        }
)

public class OpenApiConfig {
}
