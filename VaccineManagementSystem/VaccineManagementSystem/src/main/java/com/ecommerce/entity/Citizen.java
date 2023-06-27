package com.ecommerce.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "citizen")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "citizen_id")
    private Long id;

    private String name;
    private String city;
    
    @Column(name = "number_of_doses")
    private int numberOfDoses;
    
    @Column(name = "vaccination_status")
    private String vaccinationStatus;
    
    @Column(name = "vaccination_center")
    private String vaccinationCenter;

    // Constructors, getters, and setters

    // Constructor
    public Citizen() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNumberOfDoses() {
		return numberOfDoses;
	}

	public void setNumberOfDoses(int numberOfDoses) {
		this.numberOfDoses = numberOfDoses;
	}

	public String getVaccinationStatus() {
		return vaccinationStatus;
	}

	public void setVaccinationStatus(String vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	public String getVaccinationCenter() {
		return vaccinationCenter;
	}

	public void setVaccinationCenter(String vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

    
}
