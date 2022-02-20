package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Admin;
import com.example.demo.Services.AdminService;

@RestController
@RequestMapping("/")
public class AdminController 
{

	@Autowired
	AdminService adminservice;
	
	@PostMapping(path="admin/signup", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String adminSignup(@RequestBody Admin admin)
	{
		return adminservice.adminSignup(admin);
		
	}

	
}