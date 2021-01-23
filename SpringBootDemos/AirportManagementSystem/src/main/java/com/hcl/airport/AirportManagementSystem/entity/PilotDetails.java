package com.hcl.airport.AirportManagementSystem.entity;

public class PilotDetails {

	private long pilotId;
	private String pilotName;
	private int pilotAge;
	private String pilotRanking;
	private String pilotCompanyName;
	private long planeId;
	private String planeAllocation;

	public PilotDetails(long pilotId, String pilotName, int pilotAge, String pilotRanking, String pilotContactNum,
			long planeId, String planeAllocation) {
		super();
		this.pilotId = pilotId;
		this.pilotName = pilotName;
		this.pilotAge = pilotAge;
		this.pilotRanking = pilotRanking;
		this.pilotCompanyName = pilotContactNum;
		this.planeId = planeId;
		this.planeAllocation = planeAllocation;
	}

	public PilotDetails() {
		super();
	}

	public long getPilotId() {
		return pilotId;
	}

	public void setPilotId(long pilotId) {
		this.pilotId = pilotId;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public int getPilotAge() {
		return pilotAge;
	}

	public void setPilotAge(int pilotAge) {
		this.pilotAge = pilotAge;
	}

	public String getPilotRanking() {
		return pilotRanking;
	}

	public void setPilotRanking(String pilotRanking) {
		this.pilotRanking = pilotRanking;
	}

	public String getPilotCompanyName() {
		return pilotCompanyName;
	}

	public void setPilotCompanyName(String pilotCompanyName) {
		this.pilotCompanyName = pilotCompanyName;
	}

	public long getPlaneId() {
		return planeId;
	}

	public void setPlaneId(long planeId) {
		this.planeId = planeId;
	}

	public String getPlaneAllocation() {
		return planeAllocation;
	}

	public void setPlaneAllocation(String planeAllocation) {
		this.planeAllocation = planeAllocation;
	}
	
	
}
