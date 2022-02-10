package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserRepository userrepository;
	
	
	@PostMapping(path="user/signup", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String UserSignup(@RequestBody User user)
	{
		User u=userrepository.save(user);
		if(u != null) {
			return "user added";
		}
		return null;
	}
}