package com.hcl.airport.AirportManagerService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.airport.AirportManagerService.entity.ManagerDetails;
import com.hcl.airport.AirportManagerService.repository.ManagerRepository;

import lombok.extern.slf4j.Slf4j;

@Service("managerService")
@Slf4j
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerRepository managerRepository;
	
	@Override
	public ManagerDetails addManagerDetails(ManagerDetails managerDetails) {
		log.info("Entered in to addManagerDetails() method ManageServiceImpl");
		Optional<ManagerDetails> managerOptional=managerRepository.findByContactNumber(managerDetails.getContactNumber());
		ManagerDetails managerDetailsObj;
		
		if(managerOptional.isPresent())
		{
			managerDetailsObj=null;
		}
		else
		{
			managerDetailsObj=managerRepository.save(managerDetails);
		}

		return managerDetailsObj;
	}

	@Override
	public List<ManagerDetails> getAllManagerDetails() {
		log.info("Entered in to getAllManagerDetails() method ManageServiceImpl");
		return managerRepository.findAll();
	}
	
	@Override
	public ManagerDetails approveManager(ManagerDetails managerDetails)
	{
		log.info("Entered in to approveManager method of ManagerServiceImpl class");
		Optional<ManagerDetails> managerDetailsOptional=managerRepository.findByContactNumber(managerDetails.getContactNumber());
		ManagerDetails managerDetailsObj=managerDetailsOptional.get();
		managerDetailsObj.setApprovalStatus("Accepted");
		return managerRepository.save(managerDetailsObj);
	}

	@Override
	public ManagerDetails rejectManager(ManagerDetails managerDetails) {
		log.info("Entered in to rejectManager method of ManagerServiceImpl class");
		Optional<ManagerDetails> managerDetailsOptional=managerRepository.findByContactNumber(managerDetails.getContactNumber());
		ManagerDetails managerDetailsObj=managerDetailsOptional.get();
		managerDetailsObj.setApprovalStatus("Rejected");
		return managerRepository.save(managerDetailsObj);
	}

	@Override
	public ManagerDetails findManagerByContactNumber(String contactNum) {

		Optional<ManagerDetails> managerDetailsOptional= managerRepository.findByContactNumber(contactNum);
		log.info("Entered in to findManagerByContactNumber( ) method of ManagerServiceImpl class"); 
		if(managerDetailsOptional.isPresent())
		{
			return managerDetailsOptional.get();
		}
		return null;
	}
	
}
