package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Citizen;
import com.ecommerce.entity.VaccinationCentre;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
	 List<Citizen> findAll();
		

}
