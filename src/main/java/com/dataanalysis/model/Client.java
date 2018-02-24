package com.dataanalysis.model;

import com.dataanalysis.arq.model.Entity;

public class Client extends Entity {

	private static final long serialVersionUID = -1590671213624005013L;

	private String cnpj;
	private String name;
	private String businessArea;
	
	public Client() {
		super();
	}
	
	public Client(String cnpj, String name, String businessArea) {
		super();
		this.cnpj = cnpj;
		this.name = name;
		this.businessArea = businessArea;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

}