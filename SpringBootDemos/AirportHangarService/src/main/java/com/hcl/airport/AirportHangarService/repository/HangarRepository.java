package com.hcl.airport.AirportHangarService.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.airport.AirportHangarService.entity.HangarDetails;

public interface HangarRepository extends JpaRepository<HangarDetails,Long>
{
	@Query("FROM HangarDetails hd WHERE hd.planeId=0")
	public Optional<List<HangarDetails>> getEmptyHanagars();
}
