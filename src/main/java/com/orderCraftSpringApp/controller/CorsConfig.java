package com.orderCraftSpringApp.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "OPTIONS", "PUT", "DELETE", "HEAD")
                .allowedHeaders("X-PINGOTHER", "Origin", "X-Requested-With", "Content-Type", "Accept")
                .maxAge(1728000);
    }
}