package com.Hackout.response_request;

import java.util.List;

public class BatchScoreRequest {
    private List<SiteDto> sites; // Simplified; adjust to your needs

	public List<SiteDto> getSites() {
		return sites;
	}

	public void setSites(List<SiteDto> sites) {
		this.sites = sites;
	}

	public BatchScoreRequest(List<SiteDto> sites) {
		super();
		this.sites = sites;
	}

	public BatchScoreRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
