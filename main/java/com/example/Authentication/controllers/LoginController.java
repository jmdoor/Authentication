package com.example.Authentication.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Authentication.services.UserService;
import com.example.Authentication.entities.User;
import com.example.Authentication.exceptions.*;


@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@Autowired
	UserService userservice; 
	

    @GetMapping("/")
    public String showGreeting(ModelMap map) {
        return "index";
    }


    @GetMapping("/login")
    public String showLogin(ModelMap map) {
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(ModelMap model, @RequestParam ("username") String username, @RequestParam ("password") String password){

        //TODO:

    	String message = userservice.loginUser(username, password);
        model.addAttribute("name", message);
    	return "loginsuccess";



    }
}
