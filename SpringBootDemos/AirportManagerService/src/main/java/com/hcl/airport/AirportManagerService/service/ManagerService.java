package com.hcl.airport.AirportManagerService.service;

import java.util.List;

import com.hcl.airport.AirportManagerService.entity.ManagerDetails;

public interface ManagerService {

	public ManagerDetails addManagerDetails(ManagerDetails managerDetails);
	public List<ManagerDetails> getAllManagerDetails();
	public ManagerDetails approveManager(ManagerDetails managerDetails);
	public ManagerDetails rejectManager(ManagerDetails managerDetails);
	public ManagerDetails findManagerByContactNumber(String contactNum);

}
