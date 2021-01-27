package com.hcl.BankingApplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.BankingApplication.entity.User;
import com.hcl.BankingApplication.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User userDetails) {
		
		log.info("Entered in to createUser method of UserServiceImpl class");
		return userRepository.save(userDetails);
	}

	@Override
	public User findByUserName(String userName) {
		
		log.info("Entered in to findByUserName method of UserServiceImpl class");
		Optional<User> userOptional=userRepository.findByUserName(userName);
		User userObj=null;
		
		if(userOptional.isPresent())
		{
			userObj=userOptional.get();
		}
		else
		{
			userObj=null;
		}
		return userObj;
	}

}
