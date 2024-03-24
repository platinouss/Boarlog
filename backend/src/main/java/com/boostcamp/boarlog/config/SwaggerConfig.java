package com.boostcamp.boarlog.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().components(new Components()).info(swaggerInfo());
    }

    private Info swaggerInfo() {
        return new Info()
                .title("Boarlog API 명세서")
                .description("Boarlog 서비스에서 제공하는 API 명세서입니다.")
                .version("1.0");
    }
}
