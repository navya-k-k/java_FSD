package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes) {

        // Query the database to check if the credentials are valid
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            redirectAttributes.addFlashAttribute("message", "Login successful!");
            return "redirect:/vaccinationcentre";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid credentials,User not found!");
            return "redirect:/login";
        }
    }
}

