package com.dataanalysis.dto;

public class SalesDTO {

	private Integer id;
	private Double totalPrice;

	public SalesDTO() {
		super();
	}

	public SalesDTO(Integer id, Double totalPrice) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
