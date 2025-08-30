package com.Hackout.response_request;


public class PortfolioOptimizeRequest {
    private Double budget; // e.g., 10.0 Cr
    private Integer sitesCount; // e.g., 10
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public Integer getSitesCount() {
		return sitesCount;
	}
	public void setSitesCount(Integer sitesCount) {
		this.sitesCount = sitesCount;
	}
	public PortfolioOptimizeRequest(Double budget, Integer sitesCount) {
		super();
		this.budget = budget;
		this.sitesCount = sitesCount;
	}
	public PortfolioOptimizeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}