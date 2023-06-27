package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.repository.UserRepository;
import com.ecommerce.entity.User;
@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public ModelAndView showRegistrationForm() {
        return new ModelAndView("registration");
    }

    @PostMapping("/registration")
    public String registerUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes) {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);

        redirectAttributes.addFlashAttribute("message", "Registration successful!");
        return "redirect:/login";
    }
}
