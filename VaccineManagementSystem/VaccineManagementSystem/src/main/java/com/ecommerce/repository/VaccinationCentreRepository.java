package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Citizen;
import com.ecommerce.entity.VaccinationCentre;

@Repository
public interface VaccinationCentreRepository extends JpaRepository<VaccinationCentre, Long> {
	List<VaccinationCentre> findAll();
	
	@Query("SELECT DISTINCT city FROM VaccinationCentre")
    List<String> getAllCities();
	
	Optional<VaccinationCentre> findById(Long id);
	
	 @Query("SELECT DISTINCT name FROM VaccinationCentre")
	    List<String> findAllCentres();
	 
	 
		
}
