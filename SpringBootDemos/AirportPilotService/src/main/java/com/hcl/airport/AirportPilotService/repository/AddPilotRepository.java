package com.hcl.airport.AirportPilotService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

import com.hcl.airport.AirportPilotService.entity.PilotDetails;

public interface AddPilotRepository  extends JpaRepository<PilotDetails,Long>{
	
	
	@Query("FROM PilotDetails pd WHERE pd.planeId=0")
	public Optional<List<PilotDetails>> getFreePilotDetails();

}
