package com.Hackout.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.Hackout.models.Site;
import com.Hackout.services.SiteService;

@RestController
@RequestMapping("/ml/sites")
@CrossOrigin("*")
public class SiteController {

	@Autowired
    private SiteService siteService;
	@Autowired
    private  RestTemplate restTemplate;
    
   

    
    @Value("${ai.service.url}")
    private String aiServiceUrl;
    
    @GetMapping("/hello")
    public ResponseEntity<String> displayHello(){
    

        return ResponseEntity.ok("Hello");
    }
    @GetMapping("/statistics/summary")
    public ResponseEntity<?> getSummaryStatistics() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(
                    aiServiceUrl + "/ml/statistics/summary", String.class);

            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to fetch summary statistics", e);
        }
    }
    
    @GetMapping("/nearest")
    public List<Site> getNearestSites(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam(defaultValue = "5") int limit) {

        return siteService.getNearestSites(latitude, longitude, limit);
    }
    @PostMapping("/portfolio/optimize")
    public ResponseEntity<?> optimizePortfolio(@RequestBody Map<String, Object> requestBody) {
        try {
            // Set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

            // Forward request to ML service
            ResponseEntity<String> response = restTemplate.postForEntity(aiServiceUrl + "/ml/portfolio/optimize", entity, String.class);

            // Return the ML service response
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed to call ML service",
                    e
            );
        }
    }

    
    
    @GetMapping("/top")
    public List<Site> getTop10Sites() {
        return siteService.getTopSitesByFeasibility(10);
    }
    
    @GetMapping()
    public List<Site> getAllSites() {
        return siteService.getAllSites();
    }
    
    // Get sites filtered by city
    @GetMapping("/city")
    public List<Site> getSitesByCity(@RequestParam String name,@RequestParam double cap) {
        return siteService.getSitesByCity(name,cap);
    }
    // Add /frontier/efficient if needed
}