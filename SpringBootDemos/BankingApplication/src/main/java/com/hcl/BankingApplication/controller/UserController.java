package com.hcl.BankingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.BankingApplication.entity.User;
import com.hcl.BankingApplication.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/createuseer")
	public ResponseEntity<User> createUser(@RequestBody User userDetails)
	{
		log.info("Entered in to createUser method of UserController class");
		
		return new ResponseEntity<User>(userService.createUser(userDetails),new HttpHeaders(),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getbyusername/{username}")
	public ResponseEntity<User> getByUserName(@PathVariable("username") String userName)
	{
		log.info("Entered in to getByUserName() method of UserController class");
		return new ResponseEntity<User>(userService.findByUserName(userName),new HttpHeaders(),HttpStatus.OK);		
	}
}
