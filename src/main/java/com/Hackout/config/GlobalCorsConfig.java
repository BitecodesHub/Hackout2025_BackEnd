package com.Hackout.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")       // allow all origins
                        .allowedMethods("*")       // allow GET, POST, PUT, DELETE, etc.
                        .allowedHeaders("*")       // allow all headers
                        .allowCredentials(false);  // must be false if using "*"
            }
        };
    }
}
