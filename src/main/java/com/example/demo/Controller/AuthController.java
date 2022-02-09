package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.AdminModel;
import com.example.demo.Model.LoginModel;
import com.example.demo.Service.AuthService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class AuthController {

	@Autowired
	AuthService authservice;
@PostMapping(path="user/login", consumes=MediaType.APPLICATION_JSON_VALUE)

//public boolean isUserPresent(@RequestBody String emailID, @RequestBody String password) {
 //   return userrepository.existsByid(emailID);
//}
public boolean isUserPresent(@RequestBody LoginModel login) {
	return authservice.isUserPresent(login);
}
@PostMapping(path="admin/login", consumes=MediaType.APPLICATION_JSON_VALUE)
public boolean isAdminPresent(@RequestBody AdminModel login) {
	return authservice.isAdminPresent(login);
}
    	

}
