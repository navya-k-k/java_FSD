package com.eproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eproduct.Users;
import com.eproduct.dao.UserDAO;

@Controller
public class UpdateController {

	@Autowired
	private UserDAO userDAO;
	@RequestMapping(value = "/updateUsers", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("user") Users user, Model model) {
	    boolean updateResult = userDAO.updateUser(user);
	    
	    if (updateResult) {
	        Users updatedUser = userDAO.getProductById(user.getUser_id());
	        model.addAttribute("updatedUser", updatedUser);
	        return "display"; // Display the updated product details
	    } else {
	        // Handle update failure
	        // You can add appropriate error handling logic or redirect to an error page
	        return "error-page";
	    }
	}
}