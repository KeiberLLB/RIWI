package com.Meta_Keiber.SpringBoot.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Api for the control of the entry of new coders", version = "1.0", description = "Api documentation"))
public class OpenApiConfig {

}
