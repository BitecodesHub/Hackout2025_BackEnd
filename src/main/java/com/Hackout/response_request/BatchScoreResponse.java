package com.Hackout.response_request;

import java.util.Map;


public class BatchScoreResponse {
    private Map<String, Double> scores; // City -> Score

	public Map<String, Double> getScores() {
		return scores;
	}

	public void setScores(Map<String, Double> scores) {
		this.scores = scores;
	}

	public BatchScoreResponse(Map<String, Double> scores) {
		super();
		this.scores = scores;
	}

	public BatchScoreResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}