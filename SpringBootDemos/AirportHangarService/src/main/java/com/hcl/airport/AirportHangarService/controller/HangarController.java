package com.hcl.airport.AirportHangarService.controller;

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

import com.hcl.airport.AirportHangarService.service.HangarService;

import lombok.extern.slf4j.Slf4j;

import com.hcl.airport.AirportHangarService.appexception.ListEmptyException;
import com.hcl.airport.AirportHangarService.entity.HangarDetails;

@RestController
@Slf4j
public class HangarController {

	@Autowired
	private HangarService hangarService;
	
	@PostMapping("/addhangar")
	public ResponseEntity<HangarDetails> addHangarDetails(@RequestBody HangarDetails hangarDetails)
	{
		log.info("Entered in to addHangarDetails() method of HangarController class");
		return new ResponseEntity<>(hangarService.addHangarDetails(hangarDetails),new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@GetMapping("/getallhangars")
	public ResponseEntity<List<HangarDetails>> getAllHangarDetails()
	{
		log.info("Entered in to getAllHangarDetails() method of HangarController class");
		List<HangarDetails> hangarDetailsList=hangarService.getAllHangarDetails();
		
		if(hangarDetailsList.isEmpty())
		{
			log.error("There are no hangar entites in the database to show");
			throw new ListEmptyException();
		}
		else
		{
			log.info("There is atleast one hangar entity in the database");
			return new ResponseEntity<>(hangarService.getAllHangarDetails(),new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/getemptyhangars")
	public ResponseEntity<List<HangarDetails>> getEmptyHangars()
	{
		log.info("Entered in to getEmptyHangars() method of HangarController class");
		Optional<List<HangarDetails>>optionalList=hangarService.getEmptyHangarDetails();
		
		if(optionalList.isPresent())
		{
			log.info("There is atlest one hangar in the database to show");
			return new ResponseEntity<>(optionalList.get(),new HttpHeaders(),HttpStatus.OK);
		}
		else
		{
			log.error("There are no hangar entites in the database to show");
			throw new ListEmptyException();
		}
	}
	
	@GetMapping("/allocateplane/{hangarId}/{planeId}")
	public ResponseEntity<HangarDetails> allocatePlane(@PathVariable("hangarId") long hangarId,@PathVariable("planeId")long planeId)
	{
		log.info("Entered in to allocatePlane method of HangarController class");
		return new ResponseEntity<>(hangarService.allocatePlane(hangarId, planeId),new HttpHeaders(),HttpStatus.OK);
	}
}
