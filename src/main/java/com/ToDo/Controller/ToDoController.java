package com.ToDo.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	// Create User
	@PostMapping("/registration")
	public String addUser(@ModelAttribute("user") Appuser user) {

		try {

			System.out.println(user.getFullName());
			registerService.createUser(user);
			return "redirect:login";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:Registration";
		}
	}

	// HomePage View
	@GetMapping("/todoView")
	public String homePage(HttpSession session, Model model) {

		Appuser user = (Appuser) session.getAttribute("user");

		String email = user.getEmail();
		System.out.println(email);
		List<userTask> allTask =  registerService.getUserTask(email);
		System.out.println(allTask);
		model.addAttribute("allTask", allTask);
		return "Dashboard";
	}

	
	// User Login
	@PostMapping("/userLogin")
	public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {

		Appuser user = registerService.processLogin(email, password);

		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:todoView";
		} else {
			return "login";
		}

	}

	
	// Open Create Task Page
	@GetMapping("/openCreateTask/{email}")
		public String adminUpdate(@PathVariable String email,Model model) {
			
			return "createTask";
		}

	
	
	// Create Task
	@PostMapping("/createTask")
		public String createTask(@RequestParam("email") String email,@RequestParam("taskTitle") String taskTitle, 
				@RequestParam("taskDescription") String taskDescription,Model model,HttpSession session ) {
		
		Appuser user = registerService.getUser(email);
		userTask task = new userTask();
		task.setEmail(email);
		task.setTaskTitle(taskTitle);
		task.setTaskDescription(taskDescription);
		
		registerService.createTask(task);
		
		System.out.println("Created");
		
		session.setAttribute("user", user);
			
			
			return "redirect:todoView";
		}
		
		
	//Open Task Form For Update
	@GetMapping("/taskupdate/{taskId}")
	public String adminUpdate(@PathVariable int taskId ,Model model) {
		
		userTask task = registerService.getTaskById(taskId);
		
		model.addAttribute("task", task);
		return "createTask";
	}


}
