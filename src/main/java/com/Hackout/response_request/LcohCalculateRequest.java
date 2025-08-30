package com.Hackout.response_request;


public class LcohCalculateRequest {
    private Double capexAdjustment; // e.g., -10.0%
    private Double h2PriceAdjustment; // e.g., +20.0%
	public Double getCapexAdjustment() {
		return capexAdjustment;
	}
	public void setCapexAdjustment(Double capexAdjustment) {
		this.capexAdjustment = capexAdjustment;
	}
	public Double getH2PriceAdjustment() {
		return h2PriceAdjustment;
	}
	public void setH2PriceAdjustment(Double h2PriceAdjustment) {
		this.h2PriceAdjustment = h2PriceAdjustment;
	}
	public LcohCalculateRequest(Double capexAdjustment, Double h2PriceAdjustment) {
		super();
		this.capexAdjustment = capexAdjustment;
		this.h2PriceAdjustment = h2PriceAdjustment;
	}
	public LcohCalculateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
    // Other scenario params
}