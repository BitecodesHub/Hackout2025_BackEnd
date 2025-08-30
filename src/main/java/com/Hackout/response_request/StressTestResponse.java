package com.Hackout.response_request;

import java.util.Map;

public class StressTestResponse {
    private Map<String, PortfolioOptimizeResponse> results; // Scenario -> Portfolio Response

	public Map<String, PortfolioOptimizeResponse> getResults() {
		return results;
	}

	public void setResults(Map<String, PortfolioOptimizeResponse> results) {
		this.results = results;
	}

	public StressTestResponse(Map<String, PortfolioOptimizeResponse> results) {
		super();
		this.results = results;
	}

	public StressTestResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}