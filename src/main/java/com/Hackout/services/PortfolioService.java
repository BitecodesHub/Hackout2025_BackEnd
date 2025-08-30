package com.Hackout.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hackout.response_request.PortfolioOptimizeRequest;
import com.Hackout.response_request.PortfolioOptimizeResponse;

@Service
public class PortfolioService {
    @Autowired
    private ApiClientService apiClient;

    public PortfolioOptimizeResponse optimize(PortfolioOptimizeRequest request) {
        return apiClient.post("/ml/portfolio/optimize", request, PortfolioOptimizeResponse.class);
    }

}