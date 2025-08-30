package com.Hackout.response_request;

import java.util.Map;

public class PortfolioOptimizeResponse {
    private Double expectedReturn;
    private Double riskStdDev;
    private Double sharpeRatio;
    private Integer sitesSelected;
    private Map<String, Double> topAllocations; // City -> Percentage
	public Double getExpectedReturn() {
		return expectedReturn;
	}
	public void setExpectedReturn(Double expectedReturn) {
		this.expectedReturn = expectedReturn;
	}
	public Double getRiskStdDev() {
		return riskStdDev;
	}
	public void setRiskStdDev(Double riskStdDev) {
		this.riskStdDev = riskStdDev;
	}
	public Double getSharpeRatio() {
		return sharpeRatio;
	}
	public void setSharpeRatio(Double sharpeRatio) {
		this.sharpeRatio = sharpeRatio;
	}
	public Integer getSitesSelected() {
		return sitesSelected;
	}
	public void setSitesSelected(Integer sitesSelected) {
		this.sitesSelected = sitesSelected;
	}
	public Map<String, Double> getTopAllocations() {
		return topAllocations;
	}
	public void setTopAllocations(Map<String, Double> topAllocations) {
		this.topAllocations = topAllocations;
	}
	public PortfolioOptimizeResponse(Double expectedReturn, Double riskStdDev, Double sharpeRatio,
			Integer sitesSelected, Map<String, Double> topAllocations) {
		super();
		this.expectedReturn = expectedReturn;
		this.riskStdDev = riskStdDev;
		this.sharpeRatio = sharpeRatio;
		this.sitesSelected = sitesSelected;
		this.topAllocations = topAllocations;
	}
	public PortfolioOptimizeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}