package com.hcl.airport.AirportManagementSystem.entity;

public class HangarDetails {

	private long hangarId;
	private String hangarName;
	private String hangarCapacity;
	private String hangarStatus;
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
