package com.hcl.airport.AirportAddPlaneService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.airport.AirportAddPlaneService.entity.PlaneDetails;
import com.hcl.airport.AirportAddPlaneService.repository.AddPlaneRepository;

import lombok.extern.slf4j.Slf4j;

@Service("addPlaneService")
@Slf4j
public class AddPlaneServiceImpl implements AddPlaneService{

	@Autowired
	private AddPlaneRepository addPlaneRepository;
	
	@Override
	public PlaneDetails addPlaneDetails(PlaneDetails planeDetails) {

		log.info("Entered in to addPlaneDetails() method of AddPlaneServiceImpl class in the service layer");
		return addPlaneRepository.save(planeDetails);
		
	}

	@Override
	public List<PlaneDetails> getAllPlaneDetails() {
		
		log.info("Entered in to getAllPlaneDetails()  method of AddPlaneServiceImpl class in the service layer");
		return addPlaneRepository.findAll();
	}

	@Override
	public String allocateHangar(long hangarId,long planeId) {
		
		log.info("Entered in to allocateHangar method of AddPlaneServiceImpl class of service layer");
		Optional<PlaneDetails> planeDetailsOptional=addPlaneRepository.findById(planeId);
		PlaneDetails planeDetails=null;
		
		if(planeDetailsOptional.isPresent())
		{
		  planeDetails=planeDetailsOptional.get();
		  if(planeDetails.getHangarId()==0)
		  {
			  planeDetails.setHangarId(hangarId);
			  planeDetails.setHangarAllocation("Occupied");
			  addPlaneRepository.save(planeDetails);	  
			  return "success";
		  }
		  else
		  {
			  return "alreadyOccupied";
		  }
		}
		
		else
		{
			return "invalidId";
		}
	}

	@Override
	public String allocatePilot(long pilotId, long planeId) {

		log.info("Entered in to allocatePilot method of AddPlaneServiceImpl class");
		Optional<PlaneDetails> planeDetailsOptional=addPlaneRepository.findById(planeId);
		PlaneDetails planeDetails=null;
		
		if(planeDetailsOptional.isPresent())
		{
		  planeDetails=planeDetailsOptional.get();
		  if(planeDetails.getPilotId()==0)
		  {
			  planeDetails.setPilotId(pilotId);
			  planeDetails.setPilotAllocation("Allocated");
			  addPlaneRepository.save(planeDetails);	  
			  return "success";
		  }
		  else
		  {
			  return "alreadyOccupied";
		  }
		}
		
		else
		{
			return "invalidId";
		}
	}

	@Override
	public PlaneDetails getPlaneById(long planeId) {
		log.info("Entered in to getPlaneById() method of AddPlaneServiceImpl class");
		Optional<PlaneDetails> planeDetailsOptional=addPlaneRepository.findById(planeId);
		return planeDetailsOptional.get();
	}

	@Override
	public PlaneDetails updatePlaneDetails(PlaneDetails planeDetails) {
		log.info("Entered in to updatePlaneDetails(0 method of AddPlaneServiceImpl class");
		return addPlaneRepository.save(planeDetails);
	}
}
