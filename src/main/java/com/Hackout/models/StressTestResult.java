package com.Hackout.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StressTestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String scenario; // e.g., "Base Case"
    private Double returnValue;
    private Double risk;
    private Double sharpe;
    private Integer sites;
    // Link to OptimizationResult if needed\
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public Double getReturnValue() {
		return returnValue;
	}
	public void setReturnValue(Double returnValue) {
		this.returnValue = returnValue;
	}
	public Double getRisk() {
		return risk;
	}
	public void setRisk(Double risk) {
		this.risk = risk;
	}
	public Double getSharpe() {
		return sharpe;
	}
	public void setSharpe(Double sharpe) {
		this.sharpe = sharpe;
	}
	public Integer getSites() {
		return sites;
	}
	public void setSites(Integer sites) {
		this.sites = sites;
	}
	public StressTestResult(Long id, String scenario, Double returnValue, Double risk, Double sharpe, Integer sites) {
		super();
		this.id = id;
		this.scenario = scenario;
		this.returnValue = returnValue;
		this.risk = risk;
		this.sharpe = sharpe;
		this.sites = sites;
	}
	public StressTestResult() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}