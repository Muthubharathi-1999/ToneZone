package com.example.demo.Controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.UserModel;
import com.example.demo.Service.UserService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {
	
	@Autowired
	UserService uservice;
	
	@PutMapping("/editUser")
	public UserModel editUser(@RequestBody UserModel usermodel)
	{
		return uservice.editUser(usermodel);
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestParam int UserID)
	{
		uservice.deleteUser(UserID);
	}
	
}
