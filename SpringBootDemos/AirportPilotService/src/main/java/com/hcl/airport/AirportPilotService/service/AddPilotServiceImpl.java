package com.hcl.airport.AirportPilotService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.airport.AirportPilotService.entity.PilotDetails;
import com.hcl.airport.AirportPilotService.repository.AddPilotRepository;

import lombok.extern.slf4j.Slf4j;

@Service("addPilotService")
@Slf4j
public class AddPilotServiceImpl implements AddPilotService{

	@Autowired
	private AddPilotRepository addPilotRepository;
	
	@Override
	public PilotDetails addPilotDetails(PilotDetails pilotDetails) {
		log.info("Entered in to addPilotDetails() method of AddPilotServiceImpl class");
		return addPilotRepository.save(pilotDetails);
	}

	@Override
	public List<PilotDetails> getAllPilotDetails() {
		log.info("Entered in to getAllPilotDetails() method of AddPilotServiceImpl class");
		return addPilotRepository.findAll();
	}

	@Override
	public Optional<List<PilotDetails>> getFreePilotDetails() {

		log.info("Entered in to getFreePilotDetails method of AddPilotServiceImpl class");
		return addPilotRepository.getFreePilotDetails();
	}

	@Override
	public PilotDetails allocatePlane(long pilotId, long planeId) {
		
		log.info("Entered in to allocate Plane method od AddPilotServiceImpl class");
		Optional<PilotDetails> pilotDetailsOptional=addPilotRepository.findById(pilotId);
		PilotDetails pilotDetails=null;
		if(pilotDetailsOptional.isPresent())
		{
			pilotDetails=pilotDetailsOptional.get();
			pilotDetails.setPlaneId(planeId);
			pilotDetails.setPlaneAllocation("Allocated");
			addPilotRepository.save(pilotDetails);
			return pilotDetails;
		}
		else
		{
			return pilotDetails;
		}
	}

	@Override
	public PilotDetails findPilotById(long pilotId) {
		log.info("Entered in to findPilotById method of AddPilotServiceImpl class");
		Optional<PilotDetails> pilotDetailsOptional=addPilotRepository.findById(pilotId);
		return pilotDetailsOptional.get();
	}

	@Override
	public PilotDetails updatePilotDetails(PilotDetails pilotDetails) {
		log.info("Entered in to updatePilotDetails method of AddPilotServiceImpl class");
		return addPilotRepository.save(pilotDetails);
	}
}
