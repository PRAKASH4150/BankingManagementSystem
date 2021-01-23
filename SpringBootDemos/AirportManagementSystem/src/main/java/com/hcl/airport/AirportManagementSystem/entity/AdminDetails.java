package com.hcl.airport.AirportManagementSystem.entity;

public class AdminDetails {

	private long adminId;
	private String userName;
	private String password;
	
	public AdminDetails() {
		super();
	}
	public AdminDetails(long adminId, String userName, String password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
