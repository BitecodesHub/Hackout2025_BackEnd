package com.Hackout.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OptimizationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double expectedReturn;
    private Double riskStdDev;
    private Double sharpeRatio;
    private Integer sitesSelected;
    private String topAllocations; // JSON string or separate entity for allocations
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getTopAllocations() {
		return topAllocations;
	}
	public void setTopAllocations(String topAllocations) {
		this.topAllocations = topAllocations;
	}
	public OptimizationResult(Long id, Double expectedReturn, Double riskStdDev, Double sharpeRatio,
			Integer sitesSelected, String topAllocations) {
		super();
		this.id = id;
		this.expectedReturn = expectedReturn;
		this.riskStdDev = riskStdDev;
		this.sharpeRatio = sharpeRatio;
		this.sitesSelected = sitesSelected;
		this.topAllocations = topAllocations;
	}
	public OptimizationResult() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    // Add fields for budget, etc.
}