package com.hcl.airport.AirportHangarService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hangar_details")
public class HangarDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long hangarId;
	
	@Column(name="hangar_name",nullable=false,length=30)
	private String hangarName;
	
	@Column(name="hangar_capacity",nullable=false,length=30)
	private String hangarCapacity;
	
	@Column(name="hangar_status",nullable=true,length=30)
	private String hangarStatus;
	
	@Column(name="plane_id",nullable=true)
	long planeId;


	public HangarDetails() {
		super();
	}


	public HangarDetails(long hangarId, String hangarName, String hangarCapacity, String hangarStatus, long planeId) {
		super();
		this.hangarId = hangarId;
		this.hangarName = hangarName;
		this.hangarCapacity = hangarCapacity;
		this.hangarStatus = hangarStatus;
		this.planeId = planeId;
	}


	public long getHangarId() {
		return hangarId;
	}


	public void setHangarId(long hangarId) {
		this.hangarId = hangarId;
	}


	public String getHangarName() {
		return hangarName;
	}


	public void setHangarName(String hangarName) {
		this.hangarName = hangarName;
	}


	public String getHangarCapacity() {
		return hangarCapacity;
	}


	public void setHangarCapacity(String hangarCapacity) {
		this.hangarCapacity = hangarCapacity;
	}


	public String getHangarStatus() {
		return hangarStatus;
	}


	public void setHangarStatus(String hangarStatus) {
		this.hangarStatus = hangarStatus;
	}


	public long getPlaneId() {
		return planeId;
	}


	public void setPlaneId(long planeId) {
		this.planeId = planeId;
	}

	
	
}
