package com.hcl.airport.AirportHangarService.service;

import java.util.List;
import java.util.Optional;

import com.hcl.airport.AirportHangarService.entity.HangarDetails;

public interface HangarService {

	public HangarDetails addHangarDetails(HangarDetails hangarDetails);
	public List<HangarDetails> getAllHangarDetails();
	public Optional<List<HangarDetails>> getEmptyHangarDetails();
	public HangarDetails allocatePlane(long hangarId,long planeId);
}
