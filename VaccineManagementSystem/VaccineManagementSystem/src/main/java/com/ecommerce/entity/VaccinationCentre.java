package com.ecommerce.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccinecentre")
public class VaccinationCentre {

    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    private Long id;

    private String name;

    private String city;
    
    
 public VaccinationCentre() {
    	
    }



	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this. name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

    
}
