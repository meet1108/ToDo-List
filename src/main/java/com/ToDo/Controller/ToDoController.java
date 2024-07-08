package com.ToDo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ToDo.Model.Appuser;
import com.ToDo.Model.userTask;
import com.ToDo.Service.RegisterService;





@Controller
public class ToDoController {
	
	private RegisterService registerService;
	
	@Autowired
	public ToDoController(RegisterService registerService) {
		
		this.registerService = registerService;
	}
	


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
	public String addUser(@ModelAttribute("user") Appuser user) {

		try {
			
			System.out.println(user.getFullName());
			registerService.createUser(user);
			return "redirect:login";
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:Registration";
		}
	}
	
	//User Login
	@PostMapping("/userLogin")
	public String loginUser(@RequestParam("email") String email,
            @RequestParam("password") String password,Model model ) {
		try {
			Appuser user = registerService.processLogin(email, password);
			model.addAttribute("user",user);
			
			List<userTask> allTask = registerService.userTask(email);
			model.addAttribute("allTask", allTask);
			return "Dashboard";
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:login";		
			}
	}

	
	//Open Create Task Page
	@GetMapping("/create")
	public String openCreateTask() {
		
		return "createTask";
	}
	
	
	//Create Task
	@PostMapping("/createTask")
	public String createTask(@ModelAttribute("task") userTask task) {
		
		registerService.createTask(task);
		return "Dashboard";
	}


	
	
	
	
	
	
	
	
	
	
}
