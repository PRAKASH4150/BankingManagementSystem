package com.hcl.airport.AirportManagementSystem.entity;

public class ManagerCredentials {

	private String contactNumber;
	private String password;
	

	public ManagerCredentials(String contactNumber, String password) {
		super();
		this.contactNumber = contactNumber;
		this.password = password;
	}


	public ManagerCredentials() {
		super();
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
