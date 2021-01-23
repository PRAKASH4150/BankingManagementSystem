package com.hcl.airport.AirportPilotService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
