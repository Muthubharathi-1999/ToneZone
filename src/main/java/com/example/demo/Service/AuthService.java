package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.AdminModel;
import com.example.demo.Model.LoginModel;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	UserRepository userrepository;
	@Autowired
	AdminRepository adminrepository;
	
	public boolean isUserPresent(LoginModel login) {
		//System.out.println(login.getEmailID());
	    boolean emailb = userrepository.existsByEmail(login.getEmailID());
	    boolean passb = userrepository.existsByPassword(login.getPassword());
	    if((emailb) & (passb)) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	public boolean isAdminPresent(AdminModel login) {
		//System.out.println(login.getEmailID());
	    boolean emailb = adminrepository.existsByEmail(login.getEmailID());
	    boolean passb = adminrepository.existsByPassword(login.getPassword());
	    if((emailb) & (passb)) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
}
