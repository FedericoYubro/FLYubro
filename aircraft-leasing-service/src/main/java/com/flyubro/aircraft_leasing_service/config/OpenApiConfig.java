package com.flyubro.aircraft_leasing_service.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${lessor.dev-url}")
    private String devUrl;

    @Value("${lessor.prod-url}")
    private String prodUrl;

    @Bean
    @Primary
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server en Desarrollo");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server en Producción");

        Contact contact = new Contact();
        contact.setEmail("flyubro@gmail.com");
        contact.setName("Fede");
        contact.setUrl("https://www.lessors-air.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Lessors Aircraft")
                .version("1.0")
                .contact(contact)
                .description("This API exposes aircraft for leasing.")
                .termsOfService("https://www.lessors-air.com/terms")
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))  // Asociar la seguridad a las rutas
                .components(new Components()
                        .addSecuritySchemes("basicAuth",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")));
    }

}
