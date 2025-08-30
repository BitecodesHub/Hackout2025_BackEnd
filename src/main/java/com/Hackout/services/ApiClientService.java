package com.Hackout.services;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.Hackout.config.ApiCallException;

@Service
public class ApiClientService {
    private final RestTemplate restTemplate;
    private  String baseUrl="Http";

    public ApiClientService(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public <T> T post(String endpoint, Object request, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> entity = new HttpEntity<>(request, headers);
        try {
            return restTemplate.postForObject(baseUrl + endpoint, entity, responseType);
        } catch (RestClientException e) {
            throw new ApiCallException("AI API call failed: " + e.getMessage(), e);
        }
    }

    // Add GET method if needed
    public <T> T get(String endpoint, Class<T> responseType) {
        try {
            return restTemplate.getForObject(baseUrl + endpoint, responseType);
        } catch (RestClientException e) {
            throw new ApiCallException("AI API call failed: " + e.getMessage(), e);
        }
    }
}