package com.dataanalysis.model;

import com.dataanalysis.arq.model.Entity;

public class Seller extends Entity {

	private static final long serialVersionUID = 5424050150910280978L;

	private String cpf;
	private String name;
	private Double salary;

	public Seller() {
		super();
	}
	
	public Seller(String cpf, String name, Double salary) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
