package com.veer.oauth.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.veer.oauth.Dao.EmployeeRepository;
import com.veer.oauth.model.Employee;
import com.veer.oauth.model.Provider;


@Controller
public class MainController {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@ResponseBody
	@GetMapping("/hey")
	public String sayHello() {
		return "Hello Mr.Veer";
	}

	
	@GetMapping("/register")
	public String REgistrationPage() {
		
		return "Registration";
	}

	
	@PostMapping("/doregister")
	public String RegistrationProcess(@ModelAttribute("employee") Employee employee) {
		try {
			employee.setRole("ROLE_USER");
			employee.setAuthProvider(Provider.LOCALE.toString());
			employee.setPassword(this.passwordEncoder.encode(employee.getPassword()));
			System.out.println("Employee details: "+employee);
			Employee save = this.employeeRepo.save(employee);
			return "login";
		} catch (Exception e) {
			e.printStackTrace();
			return "Registration";
		}
	}
	

	
	@GetMapping("/login")
	public String Login() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String PostLOgin() {
		
		return "login";
	}
	
	
	
	
	
	@GetMapping("/dashboard")
	public String GetDashBoard(Principal principal, Model model) {
		String username = principal.getName();
		System.out.println("username at Controller : "+username );
		Employee employee = employeeRepo.findByUsername(username);
		model.addAttribute("loggedInUser", employee);
		return "UserDashboard";
	}
	
	
	@GetMapping("/dashboard/{email}")
	public String GetDashBoardByOauthLogin(@PathVariable("email") String email, Model model) {
		
		System.out.println("username at Controller : "+email );
		Employee employee = employeeRepo.findByUsername(email);
		model.addAttribute("loggedInUser", employee);
		return "UserDashboard";
	}
	

}
