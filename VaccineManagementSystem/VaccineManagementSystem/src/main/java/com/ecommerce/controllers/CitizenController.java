package com.ecommerce.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.entity.Citizen;
import com.ecommerce.entity.VaccinationCentre;
import com.ecommerce.repository.CitizenRepository;
import com.ecommerce.repository.VaccinationCentreRepository;

@Controller
public class CitizenController {

    @Autowired
     CitizenRepository citizenRepository;
    
    @Autowired 
	VaccinationCentreRepository vaccinationCentreRepository;
    
    @GetMapping("/citizens")
    public String showCitizens(Model model) {
        List<Citizen> citizens = citizenRepository.findAll();
        int totalCitizens = citizens.size();
        model.addAttribute("citizens", citizens);
        model.addAttribute("totalCitizens", totalCitizens);
        return "citizens";
    }


    @GetMapping("/add-citizen")
    public String showAddCitizenForm(Model model) {
        List<String> cities = vaccinationCentreRepository.getAllCities();
        List<String> vaccineCentres= vaccinationCentreRepository.findAllCentres();
        model.addAttribute("cities", cities);
        model.addAttribute("vaccineCentres", vaccineCentres);
        model.addAttribute("centre", new VaccinationCentre());
        model.addAttribute("citizen", new Citizen());
        return "add-citizen";
    }
    
    @PostMapping("/add-citizen")
    public String addCitizen(@ModelAttribute("citizen") Citizen citizen) {
    	citizen.setNumberOfDoses(0);
        citizen.setVaccinationStatus("Not Vaccinated");

        citizenRepository.save(citizen);
        
        
        return "redirect:/citizensuccess";
    }
    
    @GetMapping("/citizensuccess")
    public String showCitizenSuccessPage() {
        return "citizensuccess";
    }
    
    
    @GetMapping("/edit-citizen/{id}")
    public String showEditCitizenForm(@PathVariable("id") Long id, Model model) {
        Citizen citizen = citizenRepository.findById(id).orElse(null);
       

        List<String> vaccineCentres = vaccinationCentreRepository.findAllCentres();
        List<String> cities = vaccinationCentreRepository.getAllCities();

        model.addAttribute("vaccineCentres", vaccineCentres);
        model.addAttribute("cities", cities);
        model.addAttribute("citizen", citizen);

        return "edit-citizen";
    }
    @PostMapping("/edit-citizen/{id}")
    public String editCitizen(@ModelAttribute("citizen") Citizen citizen) {
    	
    	if (citizen.getNumberOfDoses() == 1) {
            citizen.setVaccinationStatus("Partially Vaccinated");
        } else if (citizen.getNumberOfDoses() == 2) {
            citizen.setVaccinationStatus("Fully Vaccinated");
        } else {
            citizen.setVaccinationStatus("Not Vaccinated");
        }

        citizenRepository.save(citizen);
        
        return "editsuccess";
    }
    
	
    @GetMapping("/view-citizen/{id}")
    public String viewCitizen(@PathVariable("id") Long id, Model model) {
        Citizen citizen = citizenRepository.findById(id).orElse(null);
       
        model.addAttribute("citizen", citizen);
        return "citizenview";
    } 
    
	
    
}