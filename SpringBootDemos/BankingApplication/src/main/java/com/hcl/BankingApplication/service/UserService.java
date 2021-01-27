package com.hcl.BankingApplication.service;

import com.hcl.BankingApplication.entity.User;

public interface UserService {

	public User createUser(User userDetails);
	public User findByUserName(String userName);
}
