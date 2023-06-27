package com.ecommerce.controllers;
import java.util.Optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.repository.CitizenRepository;
import com.ecommerce.repository.VaccinationCentreRepository;

import com.ecommerce.entity.*;

@Controller
public class VaccinationCentreController {

	
	  @Autowired 
	   VaccinationCentreRepository vaccinationCentreRepository;
		
		 @Autowired 
		 CitizenRepository citizenRepository;
		 
		/*
		 * @Autowired private VaccinationCentreService vaccinationCentreService;
		 */
    
    @GetMapping("/vaccinationcentre")
    public ModelAndView showVaccinationCentres() {
        ModelAndView modelAndView = new ModelAndView("vaccinationcentre");
        List<VaccinationCentre> centres = vaccinationCentreRepository.findAll();
        modelAndView.addObject("vaccinecentre", centres);
        return modelAndView;
    }
    
    
    @GetMapping("/add-centre")
    public String showNewCentreForm(Model model) {
        List<String> cities = vaccinationCentreRepository.getAllCities();
        model.addAttribute("cities", cities);
        model.addAttribute("centre", new VaccinationCentre());
        return "newcentre";
    }
    
    @PostMapping("/add-centre")
    public String addCentre(@ModelAttribute("centre") VaccinationCentre centre) {
    	vaccinationCentreRepository.save(centre);
        
        
        return "addsuccess";
    }

    @GetMapping("/edit-centre/{id}")
    public String showEditCentreForm(@PathVariable("id") Long id, Model model) {
        VaccinationCentre centre = vaccinationCentreRepository.findById(id).orElse(null);
        List<String> cities = vaccinationCentreRepository.getAllCities();
        model.addAttribute("centre", centre);
        model.addAttribute("cities", cities);
        return "editcentre";
    }

		
    

    @PostMapping("/edit-centre/{id}")
    public String editCentre(@ModelAttribute("centre") VaccinationCentre centre) {
        vaccinationCentreRepository.save(centre);
        
        return "updatesuccess";
    }
    
    
    @GetMapping("/delete-centre/{id}")
    public String deleteCentre(@PathVariable("id") Long id) {
        vaccinationCentreRepository.deleteById(id);
        return "deletesuccess";
    }
    
	/*
	 * @GetMapping("/view-centre/{id}") public String viewCentre(@PathVariable("id")
	 * Long id, Model model) { VaccinationCentre centre =
	 * vaccinationCentreRepository.findById(id);
	 * 
	 * model.addAttribute("centre", centre);
	 * 
	 * return "view"; }
	 */

}
