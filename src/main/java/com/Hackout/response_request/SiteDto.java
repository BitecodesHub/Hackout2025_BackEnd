package com.Hackout.response_request;

public class SiteDto {
    private String city;
    private Double latitude;
    private Double longitude;
    // Add other fields
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public SiteDto(String city, Double latitude, Double longitude) {
		super();
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public SiteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
