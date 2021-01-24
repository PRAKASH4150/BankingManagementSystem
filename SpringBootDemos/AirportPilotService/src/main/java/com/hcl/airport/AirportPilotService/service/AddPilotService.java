package com.hcl.airport.AirportPilotService.service;

import java.util.List;
import java.util.Optional;

import com.hcl.airport.AirportPilotService.entity.PilotDetails;

public interface AddPilotService {

	public PilotDetails addPilotDetails(PilotDetails pilotDetails);
	
	public List<PilotDetails> getAllPilotDetails();
	
	public Optional<List<PilotDetails>> getFreePilotDetails();
	
	public PilotDetails allocatePlane(long pilotId,long planeId);
	
	public PilotDetails findPilotById(long pilotId);
	
	public PilotDetails updatePilotDetails(PilotDetails pilotDetails);
}
