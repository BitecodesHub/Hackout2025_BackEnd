package com.Hackout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hackout.response_request.LcohCalculateRequest;
import com.Hackout.response_request.LcohCalculateResponse;

@Service
public class LcohService {
    @Autowired
    private ApiClientService apiClient;

    public LcohCalculateResponse calculate(LcohCalculateRequest request) {
        return apiClient.post("/ml/lcoh/calculate", request, LcohCalculateResponse.class);
    }
}