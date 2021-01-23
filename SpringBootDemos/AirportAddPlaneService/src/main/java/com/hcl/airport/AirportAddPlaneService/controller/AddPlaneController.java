package com.hcl.airport.AirportAddPlaneService.controller;

import java.util.List;

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

import com.hcl.airport.AirportAddPlaneService.appexceptions.ListEmptyException;
import com.hcl.airport.AirportAddPlaneService.entity.PlaneDetails;
import com.hcl.airport.AirportAddPlaneService.service.AddPlaneService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AddPlaneController {

	@Autowired
    private AddPlaneService addPlaneService;
	
	@PostMapping("/addplane")
	public ResponseEntity<PlaneDetails> addPlaneDetails(@RequestBody PlaneDetails planeDetails)
	{	
		log.info("Entered into addPlaneDetails() method of AddPlaneController class");
		return new ResponseEntity<>(addPlaneService.addPlaneDetails(planeDetails),new HttpHeaders(),HttpStatus.CREATED);	
	}
	
	@GetMapping("/getallplanes")
	public ResponseEntity<List<PlaneDetails>> getAllPlaneDetails()
	{
		List<PlaneDetails> planeDetailsList=addPlaneService.getAllPlaneDetails();
		log.info("Entered into getAllPlaneDetails() method of AddPlaneController class");
		
		if(planeDetailsList.isEmpty())
		{
			log.error("There are no planes in the database to show");
			throw new ListEmptyException();
		}
		else
		{
			log.info("There is atleast one plane in the database to show");
			return new ResponseEntity<>(planeDetailsList,new HttpHeaders(),HttpStatus.OK);	
		}
	}
	
	@PutMapping("/allocatehangar/{hangarId}/{planeId}")
	public ResponseEntity<String> allocateHangar(@PathVariable("hangarId") long hangarId,@PathVariable("planeId") long planeId)
	{
		return new ResponseEntity<>(addPlaneService.allocateHangar(hangarId, planeId),new HttpHeaders(),HttpStatus.OK);
	}
}
