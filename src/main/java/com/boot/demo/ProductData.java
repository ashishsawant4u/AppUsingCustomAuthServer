package com.boot.demo;

public class ProductData {

	private String productCode;
	
	private String name;
	
	private String description;
	
	private double unitPrice;
	
	public ProductData() {}

	public ProductData(String productCode, String name, String description, double unitPrice) {

		this.productCode = productCode;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
