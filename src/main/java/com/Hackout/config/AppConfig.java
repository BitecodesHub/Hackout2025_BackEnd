// In AppConfig.java, keep the passwordEncoder() method and remove it from SecurityConfig.java
package com.Hackout.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.Hackout.services.ApiClientService;
import com.google.api.client.util.Value;

@Configuration
public class AppConfig {

	@Value("${ai.api.url}")
    private String apiUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public ApiClientService apiClientService(RestTemplate restTemplate) {
        return new ApiClientService(restTemplate, apiUrl);
    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    
}
