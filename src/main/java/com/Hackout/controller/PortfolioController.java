package com.Hackout.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hackout.response_request.PortfolioOptimizeRequest;
import com.Hackout.response_request.PortfolioOptimizeResponse;
import com.Hackout.response_request.StressTestRequest;
import com.Hackout.response_request.StressTestResponse;
import com.Hackout.services.PortfolioService;
import com.Hackout.services.StressTestService;

@RestController
@RequestMapping("/ml/portfolio")
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private StressTestService stressTestService;

    @PostMapping("/optimize")
    public PortfolioOptimizeResponse optimize(@RequestBody PortfolioOptimizeRequest request) {
        return portfolioService.optimize(request);
    }

    @PostMapping("/stress-test")
    public StressTestResponse stressTest(@RequestBody StressTestRequest request) {
        return stressTestService.runStressTest(request);
    }
}