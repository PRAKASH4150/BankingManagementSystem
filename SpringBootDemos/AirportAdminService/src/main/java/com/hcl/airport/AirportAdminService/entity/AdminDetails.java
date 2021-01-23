package com.hcl.airport.AirportAdminService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_details")
public class AdminDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long adminId;
	
	@Column(name="username",nullable=false,length=30)
	private String userName;
	
	@Column(name="password",nullable=false,length=30)
	private String password;

	
	public AdminDetails(long adminId, String userName, String password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
	}

	
	public AdminDetails() {
		super();
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
