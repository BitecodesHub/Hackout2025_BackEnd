package com.Hackout.response_request;


import java.util.Map;
public class ShapExplainResponse {
    private Map<String, Double> featureImportance;

	public Map<String, Double> getFeatureImportance() {
		return featureImportance;
	}

	public void setFeatureImportance(Map<String, Double> featureImportance) {
		this.featureImportance = featureImportance;
	}

	public ShapExplainResponse(Map<String, Double> featureImportance) {
		super();
		this.featureImportance = featureImportance;
	}

	public ShapExplainResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}