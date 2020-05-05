package com.CapG.Delight.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DistributorDetails {
	
	@Id
	private String distributorid;
	private String name;
	private String address;
	private String phone;
	public String getDistributorid() {
		return distributorid;
	}
	public void setDistributorid(String distributorid) {
		this.distributorid = distributorid;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
