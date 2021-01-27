package com.hcl.BankingApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.BankingApplication.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	public Optional<User> findByUserName(String userName);
}
