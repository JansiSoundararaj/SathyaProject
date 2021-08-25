package com.sathya.mobilePage;

import org.testng.annotations.DataProvider;

public class ProductInformation {
	private String brand,regularPrice,currentPrice,youSaved,frontCamera,rearCamera,ramCapacity,romCapacity,operatingSystem,processor;
	public ProductInformation(String brand, String regularPrice, String currentPrice, String youSaved, String frontCamera, String rearCamera, String ramCapacity, String romCapacity, String operatingSystem, String processor)
	{
		this.brand=brand;
		this.regularPrice=regularPrice;
		this.currentPrice=currentPrice;
		this.youSaved=youSaved;
		this.frontCamera=frontCamera;
		this.rearCamera=rearCamera;
		this.ramCapacity=ramCapacity;
		this.romCapacity=romCapacity;
		this.operatingSystem=operatingSystem;
		this.processor=processor;
	}
	public String getBrand() {
		return brand;
	}
	public String getRegularPrice() {
		return regularPrice;
	}
	public String getCurrentPrice() {
		return currentPrice;
	}
	public String getYouSaved() {
		return youSaved;
	}
	public String getFrontCamera() {
		return frontCamera;
	}
	public String getRearCamera() {
		return rearCamera;
	}
	public String getRamCapacity() {
		return ramCapacity;
	}
	public String getRomCapacity() {
		return romCapacity;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public String getProcessor() {
		return processor;
	}
//	@DataProvider(name="getMobileDetails")
//	public String toString() {
//		
//		return brand+regularPrice+currentPrice+youSaved+frontCamera+rearCamera+ramCapacity+romCapacity+operatingSystem+processor;
//	}

}
