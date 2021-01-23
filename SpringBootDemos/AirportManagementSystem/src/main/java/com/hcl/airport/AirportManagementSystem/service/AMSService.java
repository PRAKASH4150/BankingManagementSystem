package com.hcl.airport.AirportManagementSystem.service;

import java.util.List;

import com.hcl.airport.AirportManagementSystem.entity.AdminDetails;
import com.hcl.airport.AirportManagementSystem.entity.HangarDetails;
import com.hcl.airport.AirportManagementSystem.entity.ManagerCredentials;
import com.hcl.airport.AirportManagementSystem.entity.ManagerDetails;
import com.hcl.airport.AirportManagementSystem.entity.PilotDetails;
import com.hcl.airport.AirportManagementSystem.entity.PlaneDetails;

public interface AMSService {

	public AdminDetails validateAdmin(AdminDetails adminDetails);
	public PlaneDetails addPlaneRemote(PlaneDetails planeDetails);
	public PilotDetails addPilotRemote(PilotDetails pilotDetails);
    public HangarDetails addHangarRemote(HangarDetails hangarDetails);
    public ManagerDetails addManagerRemote(ManagerDetails managerDetails);
    public List<ManagerDetails> getManagersList();
	public ManagerDetails approveManagerRemote(ManagerDetails managerDetails);
	public ManagerDetails rejectManagerRemote(ManagerDetails managerDetails);
	public String validateManagerRemote(ManagerCredentials managerCredentials);
	public List<HangarDetails> getEmptyHangarDetails();
	public String allocateHangarRemote(long hangarId,long planeId);
}
