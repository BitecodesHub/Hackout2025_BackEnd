package com.Hackout.response_request;


public class SingleScoreRequest {
    private SiteDto site;

    public SingleScoreRequest() {}

    public SingleScoreRequest(SiteDto site) {
        this.site = site;
    }

    public SiteDto getSite() {
        return site;
    }

    public void setSite(SiteDto site) {
        this.site = site;
    }
}
