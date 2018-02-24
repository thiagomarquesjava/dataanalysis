package com.dataanalysis.model;

import com.dataanalysis.arq.model.Entity;

public class Item extends Entity {

	private static final long serialVersionUID = 2818761998455551798L;

	private Integer id;
	private Integer quantity;
	private Double price;
	
	public Item() {
		super();
	}
	
	public Item(Integer id, Integer quantity, Double price) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
