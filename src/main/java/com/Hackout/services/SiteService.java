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

 // Static constants for India (assumptions)
    private static final double INITIAL_INVESTMENT = 50_00_00_000; // 50 Cr INR
    private static final double OPEX_FACTOR = 0.03; // ~3% of CAPEX per year
    private static final double GRID_FEES = 50_00_000; // ~2.5 Cr INR/year (scaled down from 5 Cr)
    private static final double TAXES = 10_00_000; // ~1 Cr INR/year (scaled down from 2 Cr)
    private static final double SUBSIDIES = 6_00_00_000; // ~5 Cr INR/year (scaled down from 10 Cr)
    private static final double OXYGEN_REVENUE = 50_00_000; // ~0.5 Cr INR/year (scaled down from 1 Cr)
    private static final double H2_PRICE = 397; // INR/kg (auction 2025, unchanged)

    private static final String FILE_PATH = "sites.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public TopSitesResponse getTopSites(TopSitesRequest request) {
        String endpoint = "/ml/sites/top?region=" + request.getRegion();
        return apiClient.get(endpoint, TopSitesResponse.class);
    }

    public List<Site> getSitesByCity(String city,double cap) {
        String search = city.toLowerCase();
        List<Site> sites = null;

       sites=getAllSites()
                .stream()
                .filter(site -> site.getCity() != null && site.getCity().toLowerCase().contains(search))
                .collect(Collectors.toList());
       System.err.println(sites.toString());
       sites.forEach(site -> enrichWithEconomics(site, cap));
       
         return sites;
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

    // Get top N sites based on feasibility score (LCOH + ROI enriched)
    public List<Site> getTopSitesByFeasibility(int limit) {
        List<Site> allSites = getAllSites();

//        allSites.forEach(this::enrichWithEconomics);
        allSites.forEach(site -> enrichWithEconomics(site, null));

        return allSites.stream()
                .sorted(Comparator
                        .comparingDouble(Site::getFeasibilityScore)
                        .reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    /**
     * Enrich a Site with calculated LCOH and ROI.
     */
    private void enrichWithEconomics(Site site, Double cap) {
        System.err.println(cap);

        double capex = (cap != null && cap > 0) ? cap : INITIAL_INVESTMENT;
        double opex = capex * OPEX_FACTOR;
        double hydrogenProduction = site.getHydrogenProduction() > 0 ? site.getHydrogenProduction() : 1000.0;

        if (hydrogenProduction <= 0) {
            site.setLcoh(0);
            site.setRoi(0);
            return;
        }

        double annualProduction = hydrogenProduction * 365;

        // LCOH formula
        double lcoh = (capex + opex + GRID_FEES + TAXES - SUBSIDIES - OXYGEN_REVENUE) / annualProduction;
        site.setLcoh(lcoh);

        // ROI formula — must use capex, not INITIAL_INVESTMENT
        long roi = Math.round(((H2_PRICE - lcoh) * annualProduction) / capex);
        site.setRoi(roi);

//        site.setRoi(roi);
    }

    public List<Site> getAllSites() {
        File file = new File(FILE_PATH);
        List<Site> sites = null;

        if (file.exists()) {
            try {
                JsonNode rootNode = objectMapper.readTree(file);
                JsonNode dataNode = rootNode.get("data");
                sites = objectMapper.convertValue(dataNode, new TypeReference<List<Site>>() {});
//                sites.forEach(this::enrichWithEconomics);
                sites.forEach(site -> enrichWithEconomics(site, null));

                
                return sites;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // If file doesn't exist, fetch from API
        String endpoint = "/ml/sites";
        sites = (List<Site>) apiClient.get(endpoint, Site.class);

        try {
            JsonNode rootNode = objectMapper.createObjectNode();
            ((com.fasterxml.jackson.databind.node.ObjectNode) rootNode).putObject("metadata")
                    .put("filename", "sites_cache.json")
                    .put("rows", sites.size())
                    .put("columns", 15); // original + lcoh + roi
            ((com.fasterxml.jackson.databind.node.ObjectNode) rootNode).set("data",
                    objectMapper.valueToTree(sites));

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sites;
    }
}
