package com.Hackout.response_request;


public class LcohCalculateResponse {
    private String lcohRange; // e.g., "$5.76 - $7.25"

	public String getLcohRange() {
		return lcohRange;
	}

	public void setLcohRange(String lcohRange) {
		this.lcohRange = lcohRange;
	}

	public LcohCalculateResponse(String lcohRange) {
		super();
		this.lcohRange = lcohRange;
	}

	public LcohCalculateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}