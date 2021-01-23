package com.hcl.airport.AirportManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.airport.AirportManagementSystem.entity.AdminDetails;
import com.hcl.airport.AirportManagementSystem.entity.HangarDetails;
import com.hcl.airport.AirportManagementSystem.entity.ManagerCredentials;
import com.hcl.airport.AirportManagementSystem.entity.ManagerDetails;
import com.hcl.airport.AirportManagementSystem.entity.PilotDetails;
import com.hcl.airport.AirportManagementSystem.entity.PlaneDetails;
import com.hcl.airport.AirportManagementSystem.service.AMSService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AMSController {

	@Autowired
	private AMSService amsService;
	
	@PostMapping("/validateadminremote")
	public ResponseEntity<AdminDetails> validateAdmin(@RequestBody AdminDetails adminDetails)
	{
		return new ResponseEntity<>(amsService.validateAdmin(adminDetails),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/addplaneremote")
	public ResponseEntity<PlaneDetails> addPlaneRemote(@RequestBody PlaneDetails planeDetails)
	{
		return new ResponseEntity<>(amsService.addPlaneRemote(planeDetails),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/addpilotremote")
	public ResponseEntity<PilotDetails> addPilotRemote(@RequestBody PilotDetails pilotDetails)
	{
		return new ResponseEntity<>(amsService.addPilotRemote(pilotDetails),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/addhangarremote")
	public ResponseEntity<HangarDetails> addHangarRemote(@RequestBody HangarDetails hangarDetails)
	{
		return new ResponseEntity<>(amsService.addHangarRemote(hangarDetails),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/addmanagerremote")
	public ResponseEntity<ManagerDetails> addManagerRemote(@RequestBody ManagerDetails managerDetails)
	{
		return new ResponseEntity<>(amsService.addManagerRemote(managerDetails),new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/getmanagersremote")
	public ResponseEntity<List<ManagerDetails>> getManagerListRemote()
	{
		return new ResponseEntity<>(amsService.getManagersList(),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/approvemanagerremote")
	public ResponseEntity<ManagerDetails> approveMangerRemote(@RequestBody ManagerDetails managerDetails)
	{
		return new ResponseEntity<>(amsService.approveManagerRemote(managerDetails),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/rejectmanagerremote")
	public ResponseEntity<ManagerDetails> rejectMangerRemote(@RequestBody ManagerDetails managerDetails)
	{
		return new ResponseEntity<>(amsService.rejectManagerRemote(managerDetails),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/validatemanager")
	public ResponseEntity<String> validateManagerRemote(@RequestBody ManagerCredentials managerCredentials)
	{
		return new ResponseEntity<>(amsService.validateManagerRemote(managerCredentials),new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/getemptyhangarsremote")
	public ResponseEntity<List<HangarDetails>> getEmptyHangars()
	{
		return new ResponseEntity<>(amsService.getEmptyHangarDetails(),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/allocatehangarremote/{hangarId}/{planeId}")
	public ResponseEntity<String> allocateHangarRemote(@PathVariable("hangarId") long hangarId,@PathVariable("planeId") long planeId)
	{
		return new ResponseEntity<>(amsService.allocateHangarRemote(hangarId, planeId),new HttpHeaders(),HttpStatus.OK);
	}
}
