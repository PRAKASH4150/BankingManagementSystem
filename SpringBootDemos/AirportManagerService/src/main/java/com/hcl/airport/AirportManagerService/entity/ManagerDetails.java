package com.hcl.airport.AirportManagerService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager_details")

public class ManagerDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long managerId;
	
	@Column(name="first_name",nullable=false,length=50)
	private String firstName;
	
	@Column(name="last_name",nullable=false,length=50)
	private String lastName;
	
	@Column(name="age",nullable=false)
	private int age;
	
	@Column(name="gender",nullable=false,length=10)
	private String gender;
	
	@Column(name="contact_number",nullable=false,length=12)
	private String contactNumber;
	
	@Column(name="password",nullable=false,length=12)
	private String password;
	
	@Column(name="approval_status",nullable=false,length=30)
	private String approvalStatus="Pending";

	
	public ManagerDetails(long managerId, String firstName, String lastName, int age, String gender,
			String contactNumber, String password, String approvalStatus) {
		super();
		this.managerId = managerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.password = password;
		this.approvalStatus = approvalStatus;
	}

	public ManagerDetails() {
		super();
	}
	

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	
}
