package com.hcl.BankingApplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	
	@Column(name="first_name",nullable=false,length=30)
	private String firstName;
	
	@Column(name="last_name",nullable=false,length=30)
	private String lastName;
	
	@Column(name="DOB",nullable=false,length=15)
	private Date dob;
	
	@Column(name="user_name",nullable=false,length=30)
	private String userName;
	
	@Column(name="password",nullable=false,length=30)
	private String password;
	
	@Column(name="aadhar_num",nullable=false,length=15)
	private long aadharNo;
	
	@Column(name="pan_num",nullable=false,length=15)
	private String panNo;
	
	@Column(name="status",nullable=true,length=30)
	private String status;
	
	@Column(name="role",nullable=true,length=30)
	private String role;
	
	
	public User() {
		super();
	}
	public User(long userId, String firstName, String lastName, Date dob, String userName, String password,
			long aadharNo, String panNo, String status, String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.userName = userName;
		this.password = password;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.status = status;
		this.role = role;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
