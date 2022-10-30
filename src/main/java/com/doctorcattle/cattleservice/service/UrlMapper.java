package com.doctorcattle.cattleservice.service;


public enum UrlMapper {
	
	CHECK_FARM_AND_UPDATE_LIVESTOCK("customer-service/company/farm-exists");
	
	String baseUrl = "https://doctor-cattle-customer-service.herokuapp.com/api/";
	//String baseUrl = "http://localhost:9002/api/";

	String endPoint = "";
	
	 UrlMapper(String endPoint) {
		this.endPoint = endPoint;
	}
	 
	 
	public String getUrl() {
		return this.baseUrl + this.endPoint;
	}

}

