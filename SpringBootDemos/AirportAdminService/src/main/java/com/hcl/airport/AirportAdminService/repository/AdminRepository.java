package com.hcl.airport.AirportAdminService.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.airport.AirportAdminService.entity.AdminDetails;

public interface AdminRepository extends JpaRepository<AdminDetails,Long> {

	
}
