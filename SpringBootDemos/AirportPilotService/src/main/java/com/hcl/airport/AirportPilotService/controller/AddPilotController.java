package com.hcl.airport.AirportPilotService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.airport.AirportPilotService.appexception.ListEmptyException;
import com.hcl.airport.AirportPilotService.entity.PilotDetails;
import com.hcl.airport.AirportPilotService.service.AddPilotService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AddPilotController {

	@Autowired
	private AddPilotService addPilotService; 
	
	@PostMapping("/addpilot")
	public ResponseEntity<PilotDetails> addPilotDetails(@RequestBody PilotDetails pilotDetails)
	{
		log.info("Entered in to addPilotDetails() method of AddPilotService class");
		return new ResponseEntity<>(addPilotService.addPilotDetails(pilotDetails),new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@GetMapping("/getallpilots")
	public ResponseEntity<List<PilotDetails>> getAllPilotDetails()
	{
		log.info("Entered in to getAllPilotDetails() method of AddPilotService class");
		List<PilotDetails> pilotDetailsList=addPilotService.getAllPilotDetails();
		if(pilotDetailsList.isEmpty())
		{
			log.error("There are no pilot entities in the database to show");
			throw new ListEmptyException();
		}
		else
		{
			log.info("There is atleast one pilot entity in the database to show");
			return new ResponseEntity<>(pilotDetailsList,new HttpHeaders(),HttpStatus.OK);
		}
	}
	

	@GetMapping("/getfreepilots")
	public ResponseEntity<List<PilotDetails>> getFreePilotDetails()
	{
		log.info("Entered in to getFreePilotDetails() method of AddPilotController class");
		Optional<List<PilotDetails>> pilotDetailsOptional=addPilotService.getFreePilotDetails();
		
		if(pilotDetailsOptional.isPresent())
		{
			log.info("There is atleast one pilot entity in the database to show");
			return new ResponseEntity<>(pilotDetailsOptional.get(),new HttpHeaders(),HttpStatus.OK);
		}
		else
		{
			log.error("There are no pilot entities in the database to show");
			throw new ListEmptyException();
		}
	}
	
	
	@GetMapping("/allocateplane/{pilotId}/{planeId}")
	public ResponseEntity<PilotDetails> allocatePlane(@PathVariable("pilotId") long pilotId,@PathVariable("planeId") long planeId)
	{
		log.info("Entered in to allocatePlane method of PilotController class");
		return new ResponseEntity<>(addPilotService.allocatePlane(pilotId, planeId),new HttpHeaders(),HttpStatus.OK);
	}

	@GetMapping("/findpilotbyid/{pilotId}")
	public ResponseEntity<PilotDetails> findPilotById(@PathVariable("pilotId")long pilotId)
	{
		log.info("Entered in to findPilotById method of AddPilotController class");
		return new ResponseEntity<>(addPilotService.findPilotById(pilotId),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/updatePilot")
	public ResponseEntity<PilotDetails> updatePilotDetails(@RequestBody PilotDetails pilotDetails)
	{
		log.info("Entered in to  updatePilotDetails method of AddPilotController class");
		return new ResponseEntity<>(addPilotService.updatePilotDetails(pilotDetails),new HttpHeaders(),HttpStatus.OK);

	}
}
