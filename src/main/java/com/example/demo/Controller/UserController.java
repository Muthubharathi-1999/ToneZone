package com.example.demo.Controller;

import com.example.demo.Model.LoginModel;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.UserModel;
import com.example.demo.Services.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping(path="user/signup", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public String userSignup(@RequestBody UserModel user) {
		return userService.userSignup(user);
	}

	@GetMapping("/users/all")
	public List<UserModel> getUsers() {
		return userService.getUsers();		
	}
	
	@GetMapping("/displayUser")
	public UserModel displayUser(@RequestParam int UserID) {
		return userService.displayUser(UserID);		
	}
	
	@PutMapping("/editUser")
	public UserModel editUser(@RequestBody UserModel usermodel) {
		System.out.println(usermodel);
		return userService.editUser(usermodel);
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestParam int UserID) {
		userService.deleteUser(UserID);
	}

	@PostMapping(path="user/login", consumes=MediaType.APPLICATION_JSON_VALUE)


	public String isUserPresent(@RequestBody LoginModel login) {
		return userService.isUserPresent(login);
	}
}