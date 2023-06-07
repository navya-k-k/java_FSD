package com.eproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.eproduct.Users;
import com.eproduct.dao.UserDAO;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public String getProductById(@RequestParam("user_id") int id, ModelMap map) {
		 try {
		        Users user = userDAO.getProductById(id);
		        map.addAttribute("listOfUsers", user);
		        return "update-users";
		    } catch (EmptyResultDataAccessException e) {
		        String errorMessage = "User with ID " + id + " not found.";
		        map.addAttribute("errorMessage", errorMessage);
		        return "error-page";
		    }
	    
	}
}
	



