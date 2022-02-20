package com.example.demo.Controller;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.User;
import com.example.demo.Services.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	
	@PostMapping(path="user/signup", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public String userSignup(@RequestBody User user) {
		return userservice.userSignup(user);
		
		
	}
	
	
}