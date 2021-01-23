package com.hcl.airport.AirportManagementSystem.entity;

public class PlaneDetails {
	
	long planeId;
	String planeName;
	String planeSource;
	String planeDestination;
	String planeType;
	long hangarId;
	long pilotId;
	String hangarAllocation;
	String pilotAllocation;

	public PlaneDetails(long planeId, String planeName, String planeSource, String planeDestination, String planeType,
			long hangarId, long pilotId, String hangarAllocation, String pilotAllocation) {
		super();
		this.planeId = planeId;
		this.planeName = planeName;
		this.planeSource = planeSource;
		this.planeDestination = planeDestination;
		this.planeType = planeType;
		this.hangarId = hangarId;
		this.pilotId = pilotId;
		this.hangarAllocation = hangarAllocation;
		this.pilotAllocation = pilotAllocation;
	}

	public PlaneDetails() {
		super();
	}

	public long getPlaneId() {
		return planeId;
	}

	public void setPlaneId(long planeId) {
		this.planeId = planeId;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public String getPlaneSource() {
		return planeSource;
	}

	public void setPlaneSource(String planeSource) {
		this.planeSource = planeSource;
	}

	public String getPlaneDestination() {
		return planeDestination;
	}

	public void setPlaneDestination(String planeDestination) {
		this.planeDestination = planeDestination;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public long getHangarId() {
		return hangarId;
	}

	public void setHangarId(long hangarId) {
		this.hangarId = hangarId;
	}

	public long getPilotId() {
		return pilotId;
	}

	public void setPilotId(long pilotId) {
		this.pilotId = pilotId;
	}

	public String getHangarAllocation() {
		return hangarAllocation;
	}

	public void setHangarAllocation(String hangarAllocation) {
		this.hangarAllocation = hangarAllocation;
	}

	public String getPilotAllocation() {
		return pilotAllocation;
	}

	public void setPilotAllocation(String pilotAllocation) {
		this.pilotAllocation = pilotAllocation;
	}

	@Override
	public String toString() {
		return "PlaneDetails [planeId=" + planeId + ", planeName=" + planeName + ", planeSource=" + planeSource
				+ ", planeDestination=" + planeDestination + ", planeType=" + planeType + ", hangarId=" + hangarId
				+ ", pilotId=" + pilotId + ", hangarAllocation=" + hangarAllocation + ", pilotAllocation="
				+ pilotAllocation + "]";
	}

}
