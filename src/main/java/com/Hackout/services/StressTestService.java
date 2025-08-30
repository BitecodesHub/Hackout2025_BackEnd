package com.Hackout.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hackout.response_request.StressTestRequest;
import com.Hackout.response_request.StressTestResponse;

@Service
public class StressTestService {
    @Autowired
    private ApiClientService apiClient;

    public StressTestResponse runStressTest(StressTestRequest request) {
        return apiClient.post("/ml/portfolio/stress-test", request, StressTestResponse.class);
    }
}