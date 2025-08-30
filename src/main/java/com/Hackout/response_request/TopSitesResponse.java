package com.Hackout.response_request;

import java.util.List;
import java.util.Map;

public class TopSitesResponse {
    private Map<String, List<SiteScore>> topSitesByState;
    
    // State -> List of sites with scores/LCOH

	public Map<String, List<SiteScore>> getTopSitesByState() {
		return topSitesByState;
	}

	public TopSitesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TopSitesResponse(Map<String, List<SiteScore>> topSitesByState) {
		super();
		this.topSitesByState = topSitesByState;
	}

	public void setTopSitesByState(Map<String, List<SiteScore>> topSitesByState) {
		this.topSitesByState = topSitesByState;
	}
}


class SiteScore {
    private String city;
    private Double score;
    private Double lcoh;
}