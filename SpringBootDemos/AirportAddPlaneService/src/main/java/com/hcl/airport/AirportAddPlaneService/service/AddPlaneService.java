package com.hcl.airport.AirportAddPlaneService.service;

import java.util.List;

import com.hcl.airport.AirportAddPlaneService.entity.PlaneDetails;

public interface AddPlaneService {

	public PlaneDetails addPlaneDetails(PlaneDetails planeDetails);
	public List<PlaneDetails> getAllPlaneDetails();
	public String allocateHangar(long hangarId,long planeId);
 }
