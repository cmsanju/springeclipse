package com.test.swagger.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Employee Model", description = "Employee Model for employee controller request response")
public class Employee {
	@ApiModelProperty(notes = "ID of the user")
	Integer id;
	@ApiModelProperty(notes = "name of the user")
	String name;
	@ApiModelProperty(notes = "address of the user")
	String address;
	@ApiModelProperty(notes = "department of the user")
	String department;
	@ApiModelProperty(notes = "age of the user")
	Double age;

	@ApiModelProperty(allowableValues = "active, inactive, banned")
    private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}
}
