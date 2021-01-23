package com.hcl.airport.AirportHangarService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.airport.AirportHangarService.entity.HangarDetails;
import com.hcl.airport.AirportHangarService.repository.HangarRepository;

import lombok.extern.slf4j.Slf4j;

@Service("hangarService")
@Slf4j
public class HangarServiceImpl implements HangarService{

	@Autowired
	public HangarRepository hangarRepository;
	
	public HangarDetails addHangarDetails(HangarDetails hangarDetails)
	{
		log.info("Enterd into addHangarDetails() method of HangarServiceImpl class");
		return hangarRepository.save(hangarDetails);
	}
	
	public List<HangarDetails> getAllHangarDetails()
	{
		log.info("Enterd into getAllHangarDetails() method of HangarServiceImpl class");
		return hangarRepository.findAll();
	}

	@Override
	public Optional<List<HangarDetails>> getEmptyHangarDetails() {
		log.info("Entered in to getEmptyHangarDetails() method of HangarServiceImpl class");
		return hangarRepository.getEmptyHanagars();
	}
	
	@Override
	public HangarDetails allocatePlane(long hangarId,long planeId)
	{
		log.info("Entered in to allocatePlane() method of HangarServiceImpl class");
		Optional<HangarDetails> hangarDetailsOptional=hangarRepository.findById(hangarId);
		HangarDetails hangarDetails=null;
		
		if(hangarDetailsOptional.isPresent())
		{
			hangarDetails=hangarDetailsOptional.get();
			hangarDetails.setHangarStatus("Occupied");
			hangarDetails.setPlaneId(planeId);
			return hangarRepository.save(hangarDetails);
		}
		
		else
		{
		   return hangarDetails;
		}
	}
}
