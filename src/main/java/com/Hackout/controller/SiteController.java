package com.Hackout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Hackout.models.Site;
import com.Hackout.response_request.TopSitesRequest;
import com.Hackout.response_request.TopSitesResponse;
import com.Hackout.services.SiteService;

@RestController
@RequestMapping("/ml/sites")
@CrossOrigin("*")
public class SiteController {
    @Autowired
    private SiteService siteService;

//    @GetMapping("/top")
//    public TopSitesResponse getTopSites(@RequestParam String region) {
//        TopSitesRequest request = new TopSitesRequest();
//        request.setRegion(region);
//        return siteService.getTopSites(request);
//        
//    }
    
    @GetMapping("/nearest")
    public List<Site> getNearestSites(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam(defaultValue = "5") int limit) {

        return siteService.getNearestSites(latitude, longitude, limit);
    }
    
    @GetMapping("/top")
    public List<Site> getTop10Sites() {
        return siteService.getTopSitesByHydrogenAndEfficiency(10);
    }
    
    @GetMapping()
    public List<Site> getAllSites() {
        return siteService.getAllSites();
    }
    
    // Get sites filtered by city
    @GetMapping("/city")
    public List<Site> getSitesByCity(@RequestParam String name) {
        return siteService.getSitesByCity(name);
    }
    // Add /frontier/efficient if needed
}