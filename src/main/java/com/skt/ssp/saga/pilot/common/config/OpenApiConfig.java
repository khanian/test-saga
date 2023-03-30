package com.skt.ssp.saga.pilot.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.api-docs.version}") String appVersion) {
        Info info = new Info().title("SSP2.0 OrderSaga Pilot API")
                .version(appVersion)
                .description("SSP2.o Pilot 검증을 위한 SAGA 입니다.")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache License Version 2.0").url("http://www.apache.org/license/LiCENSE-2.0"));
        
        return new OpenAPI()
                .components(new Components())
                .info(info);
        
    }
}
