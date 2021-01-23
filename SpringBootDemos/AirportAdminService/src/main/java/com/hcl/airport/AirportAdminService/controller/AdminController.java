package com.hcl.airport.AirportAdminService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.airport.AirportAdminService.entity.AdminDetails;
import com.hcl.airport.AirportAdminService.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/validateadmin")
	public ResponseEntity<AdminDetails> validateAdmin(@RequestBody AdminDetails adminDetails)
	{
		log.info("Entered in to validateAdmin method of AdminController class");
		return new ResponseEntity<>(adminService.getAdminCredentials(adminDetails),new HttpHeaders(),HttpStatus.OK);
	}
}
