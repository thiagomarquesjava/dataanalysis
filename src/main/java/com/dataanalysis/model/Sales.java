package com.dataanalysis.model;

import java.util.ArrayList;
import java.util.List;

import com.dataanalysis.arq.model.Entity;

public class Sales extends Entity {

	private static final long serialVersionUID = -2290111918310624118L;

	private Integer id;
	private List<Item> listOfItems;
	private String nameOfSeller;
	
	public Sales() {
		super();
	}
	
	public Sales(Integer id, String nameOfSeller) {
		super();
		this.id = id;
		this.nameOfSeller = nameOfSeller;
		this.listOfItems = new ArrayList<Item>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Item> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<Item> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public String getNameOfSeller() {
		return nameOfSeller;
	}

	public void setNameOfSeller(String nameOfSeller) {
		this.nameOfSeller = nameOfSeller;
	}
	
}
