package com.dataanalysis.dto;

public class SellerDTO {

	private String name;
	private Double totalSales;

	public SellerDTO() {
		super();
	}

	public SellerDTO(String name, Double totalSales) {
		super();
		this.name = name;
		this.totalSales = totalSales;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(Double totalSales) {
		this.totalSales = totalSales;
	}
	
}
