package com.Hackout.services;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hackout.models.Site;
import com.Hackout.response_request.TopSitesRequest;
import com.Hackout.response_request.TopSitesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SiteService {

    @Autowired
    private ApiClientService apiClient;

    private static final String FILE_PATH = "sites.json"; // use JSON now
    private ObjectMapper objectMapper = new ObjectMapper();

    public TopSitesResponse getTopSites(TopSitesRequest request) {
        String endpoint = "/ml/sites/top?region=" + request.getRegion();
        return apiClient.get(endpoint, TopSitesResponse.class);
    }

    public List<Site> getSitesByCity(String city) {
        return getAllSites()
                .stream()
                .filter(site -> site.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
 // Haversine formula to calculate distance in km
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Earth radius in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                 + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                 * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    // Get nearest N sites
    public List<Site> getNearestSites(double latitude, double longitude, int limit) {
        List<Site> allSites = getAllSites();

        return allSites.stream()
                .sorted(Comparator.comparingDouble(site ->
                        calculateDistance(latitude, longitude, site.getLatitude(), site.getLongitude())
                ))
                .limit(limit)
                .collect(Collectors.toList());
    }
    
 // Get top N sites based on Hydrogen Production AND System Efficiency
    public List<Site> getTopSitesByFeasibility(int limit) {
        List<Site> allSites = getAllSites();

        return allSites.stream()
                .sorted(Comparator
                        .comparingDouble(Site::getFeasibilityScore)
                        .reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<Site> getAllSites() {
        File file = new File(FILE_PATH);
        List<Site> sites = null;

        if (file.exists()) {
            try {
                // Read JSON, extract "data" array
                JsonNode rootNode = objectMapper.readTree(file);
                JsonNode dataNode = rootNode.get("data");
                sites = objectMapper.convertValue(dataNode, new TypeReference<List<Site>>() {});
                return sites;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // If file doesn't exist, fetch from API
        String endpoint = "/ml/sites";
        sites = (List<Site>) apiClient.get(endpoint, Site.class);

        // Save data to JSON file in correct format
        try {
            // Wrap sites in "metadata" + "data" structure
            JsonNode rootNode = objectMapper.createObjectNode();
            ((com.fasterxml.jackson.databind.node.ObjectNode) rootNode).putObject("metadata")
                .put("filename", "sites_cache.json")
                .put("rows", sites.size())
                .put("columns", 13); // adjust as needed
            ((com.fasterxml.jackson.databind.node.ObjectNode) rootNode).set("data",
                    objectMapper.valueToTree(sites));

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sites;
    }
}
