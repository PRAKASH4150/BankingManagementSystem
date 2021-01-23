package com.hcl.airport.AirportAdminService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.airport.AirportAdminService.entity.AdminDetails;
import com.hcl.airport.AirportAdminService.repository.AdminRepository;

import lombok.extern.slf4j.Slf4j;

@Service("adminService")
@Slf4j
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	private final long ADMINID = 1;

	@Override
	public AdminDetails getAdminCredentials(AdminDetails adminDetails) {
		log.info("Entered in to getAdminCredetials() method of AdminServiceImpl class");
		Optional<AdminDetails> adminDetailsOptional = adminRepository.findById(ADMINID);
		AdminDetails adminDetailsObj = null;
		adminDetailsObj = adminDetailsOptional.get();
		if ((adminDetailsObj.getUserName().equals(adminDetails.getUserName()))
				&& (adminDetailsObj.getPassword().equals(adminDetails.getPassword()))) {

			return adminDetailsObj;
		} else {

			return null;
		}
	}

}
