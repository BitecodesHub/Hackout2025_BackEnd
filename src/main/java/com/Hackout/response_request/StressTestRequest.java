package com.Hackout.response_request;


import java.util.List;
public class StressTestRequest {
    private List<String> scenarios; // e.g., ["Base Case", "High CAPEX"]

	public List<String> getScenarios() {
		return scenarios;
	}

	public void setScenarios(List<String> scenarios) {
		this.scenarios = scenarios;
	}

	public StressTestRequest(List<String> scenarios) {
		super();
		this.scenarios = scenarios;
	}

	public StressTestRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}