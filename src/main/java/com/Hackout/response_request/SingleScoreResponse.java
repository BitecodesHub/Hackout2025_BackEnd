package com.Hackout.response_request;


public class SingleScoreResponse {
    private String siteId; // optional, if you want to track site
    private Double score;

    public SingleScoreResponse() {}

    public SingleScoreResponse(String siteId, Double score) {
        this.siteId = siteId;
        this.score = score;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
