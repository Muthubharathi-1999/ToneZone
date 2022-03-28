package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.demo.Model.AdminModel;
import com.example.demo.Services.AdminService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/")
public class AdminController 
{

	@Autowired
	AdminService adminservice;
	
	@PostMapping(path="admin/signup", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String adminSignup(@RequestBody AdminModel admin)
	{
		return adminservice.adminSignup(admin);
		
	}

	@PostMapping(path="admin/login", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String isAdminPresent(@RequestBody AdminModel login) {
		System.out.println("inside admin");
		return adminservice.isAdminPresent(login);
	}


	
}






