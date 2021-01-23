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

}
