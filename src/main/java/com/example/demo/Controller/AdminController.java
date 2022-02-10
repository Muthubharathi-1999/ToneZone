package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Admin;
import com.example.demo.Repository.AdminRepository;

@RestController
@RequestMapping("/")
public class AdminController {

	
	@Autowired
	AdminRepository adminrepository;
	
	
	@PostMapping(path="admin/signup", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String AdminSignup(@RequestBody Admin admin)
	{
		Admin a=adminrepository.save(admin);
		if(a != null) {
			return "admin added";
		}
		return null;
	}
	
	
}