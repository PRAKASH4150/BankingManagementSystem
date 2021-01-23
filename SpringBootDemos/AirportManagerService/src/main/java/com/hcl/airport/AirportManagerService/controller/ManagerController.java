package com.hcl.airport.AirportManagerService.controller;

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

import com.hcl.airport.AirportManagerService.appexceptions.ListEmptyException;
import com.hcl.airport.AirportManagerService.entity.ManagerDetails;
import com.hcl.airport.AirportManagerService.service.ManagerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@PostMapping("/addmanager")
	public ResponseEntity<ManagerDetails> addManagerDetails(@RequestBody ManagerDetails managerDetails)
	{
		log.info("Entered into addManagerDetails() method of ManageController class");
		return new ResponseEntity<>(managerService.addManagerDetails(managerDetails),new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@GetMapping("/getallmanagers")
	public ResponseEntity<List<ManagerDetails>> getAllManagerDetails()
	{
		log.info("Entered into getAllManagerDetails() method of ManageController class");
		List<ManagerDetails> managerDetailsList=managerService.getAllManagerDetails();
		
		if(managerDetailsList.isEmpty())
		{
			log.error("There are no manager entities to show in the database");
			throw new ListEmptyException();
		}
		else
		{
			log.info("There is atleast one manager entity in the database");
			return new ResponseEntity<>(managerService.getAllManagerDetails(),new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@PutMapping("/approvemanager")
	public ResponseEntity<ManagerDetails> approveManager(@RequestBody  ManagerDetails managerDetails)
	{
		log.info("Entered in to approveManager() method of ManageController class");
		return new ResponseEntity<>(managerService.approveManager(managerDetails),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/rejectmanager")
	public ResponseEntity<ManagerDetails> rejectManager(@RequestBody  ManagerDetails managerDetails)
	{
		log.info("Entered in to rejectManager() method of ManageController class");
		return  new ResponseEntity<>(managerService.rejectManager(managerDetails),new HttpHeaders(),HttpStatus.OK);
	}

	@GetMapping("/validatemanager/{contactNum}")
	public ResponseEntity<ManagerDetails> validateManager(@PathVariable("contactNum") String contactNum)
	{
	   log.info("Entered in to validateManager() method of ManagerController class");
	   return new ResponseEntity<>(managerService.findManagerByContactNumber(contactNum),new HttpHeaders(),HttpStatus.OK);
	}
	
	
}
