package com.Hackout.response_request;


public class TopSitesRequest {
    private String region; // e.g., "Tamil Nadu"

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public TopSitesRequest(String region) {
		super();
		this.region = region;
	}

	public TopSitesRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}