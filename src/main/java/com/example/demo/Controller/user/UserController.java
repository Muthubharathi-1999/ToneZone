package com.example.demo.Controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.UserModel;
import com.example.demo.Service.UserService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {
	
	@Autowired
	UserService uservice;
	
	@GetMapping("/getUsers")
	public List<UserModel> getUsers(){
		return uservice.getUsers();		
	}
	
	@GetMapping("/displayUser")
	public UserModel displayUser(@RequestParam int UserID){
		return uservice.displayUser(UserID);		
	}
	
	@PutMapping("/editUser")
	public UserModel editUser(@RequestBody UserModel usermodel)
	{
		System.out.println(usermodel);
		return uservice.editUser(usermodel);
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestParam int UserID)
	{
		uservice.deleteUser(UserID);
	}
	
}
