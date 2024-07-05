package com.ToDo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ToDoController {

	// Starting Page and Login Page
	@RequestMapping("/")
	public String start() {
		return "login";
	}

	
	
	// Open Registration Page
	@GetMapping("/registration")
	public String registration() {
		return "Registration";
	}


	// Open ForGot Password Page
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	
	// Open ForGot Password Page
	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return "forgotPassword";
	}

	
	//Create User
	@PostMapping("/registration")
	public String addUser( ) {

		try {
			
			return "redirect:login";
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:Registration";
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
