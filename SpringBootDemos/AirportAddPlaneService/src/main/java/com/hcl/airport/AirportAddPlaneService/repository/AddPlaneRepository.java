package com.hcl.airport.AirportAddPlaneService.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.airport.AirportAddPlaneService.entity.PlaneDetails;

public interface AddPlaneRepository extends JpaRepository<PlaneDetails,Long>{

}
