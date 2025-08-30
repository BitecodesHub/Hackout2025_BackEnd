package com.Hackout.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Site {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @JsonProperty("City")
	    private String city;

	    @JsonProperty("Latitude")
	    private double latitude;

	    @JsonProperty("Longitude")
	    private double longitude;

	    @JsonProperty("Solar_Irradiance_kWh/m²/day")
	    private double solarIrradiance;

	    @JsonProperty("Temperature_C")
	    private double temperature;

	    @JsonProperty("Wind_Speed_m/s")
	    private double windSpeed;

	    @JsonProperty("PV_Power_kW")
	    private double pvPower;

	    @JsonProperty("Wind_Power_kW")
	    private double windPower;

	    @JsonProperty("Electrolyzer_Efficiency_%")
	    private double electrolyzerEfficiency;

	    @JsonProperty("Hydrogen_Production_kg/day")
	    private double hydrogenProduction;

	    @JsonProperty("Desalination_Power_kW")
	    private double desalinationPower;

	    @JsonProperty("System_Efficiency_%")
	    private double systemEfficiency;

	    @JsonProperty("Feasibility_Score")
	    private double feasibilityScore;  
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getSolarIrradiance() {
		return solarIrradiance;
	}
	public void setSolarIrradiance(double solarIrradiance) {
		this.solarIrradiance = solarIrradiance;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public double getPvPower() {
		return pvPower;
	}
	public void setPvPower(double pvPower) {
		this.pvPower = pvPower;
	}
	public double getWindPower() {
		return windPower;
	}
	public void setWindPower(double windPower) {
		this.windPower = windPower;
	}
	public double getElectrolyzerEfficiency() {
		return electrolyzerEfficiency;
	}
	public void setElectrolyzerEfficiency(double electrolyzerEfficiency) {
		this.electrolyzerEfficiency = electrolyzerEfficiency;
	}
	public double getHydrogenProduction() {
		return hydrogenProduction;
	}
	public void setHydrogenProduction(double hydrogenProduction) {
		this.hydrogenProduction = hydrogenProduction;
	}
	public double getDesalinationPower() {
		return desalinationPower;
	}
	public void setDesalinationPower(double desalinationPower) {
		this.desalinationPower = desalinationPower;
	}
	public double getSystemEfficiency() {
		return systemEfficiency;
	}
	public void setSystemEfficiency(double systemEfficiency) {
		this.systemEfficiency = systemEfficiency;
	}
	public double getFeasibilityScore() {
		return feasibilityScore;
	}
	public void setFeasibilityScore(double feasibilityScore) {
		this.feasibilityScore = feasibilityScore;
	}
	public Site(Long id, String city, double latitude, double longitude, double solarIrradiance, double temperature,
			double windSpeed, double pvPower, double windPower, double electrolyzerEfficiency,
			double hydrogenProduction, double desalinationPower, double systemEfficiency, double feasibilityScore) {
		super();
		this.id = id;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.solarIrradiance = solarIrradiance;
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.pvPower = pvPower;
		this.windPower = windPower;
		this.electrolyzerEfficiency = electrolyzerEfficiency;
		this.hydrogenProduction = hydrogenProduction;
		this.desalinationPower = desalinationPower;
		this.systemEfficiency = systemEfficiency;
		this.feasibilityScore = feasibilityScore;
	}
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

  
}
