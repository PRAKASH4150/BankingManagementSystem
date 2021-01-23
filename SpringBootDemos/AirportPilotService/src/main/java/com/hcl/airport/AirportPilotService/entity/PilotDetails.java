package com.hcl.airport.AirportPilotService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pilot_details")
public class PilotDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pilotId;
	
	@Column(name="pilot_name",nullable=false,length=50)
	private String pilotName;
	
	@Column(name="pilot_age",nullable=false)
	private int pilotAge;
	
	@Column(name="pilot_ranking",nullable=false,length=50)
	private String pilotRanking;
	
	@Column(name="pilot_company_name",nullable=false,length=50)
	private String pilotCompanyName;
	
	@Column(name="plane_id",nullable=true)
	private long planeId;
	
	@Column(name="pilot_allocation",nullable=true,length=20)
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
