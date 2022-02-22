package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.Model.AdminModel;
import com.example.demo.Model.LoginModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.*;
//import com.google.gson.Gson;  

@Service
public class AuthService {
	
	@Autowired
	UserRepository userrepository;
	@Autowired
	AdminRepository adminrepository;
	@Autowired
	EncodePass encodePass;

	
	public String isUserPresent(LoginModel login) {
		// System.out.println("mail:"+login.getEmailID());
		UserModel user = userrepository.findByemail(login.getEmailID());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// System.out.println("pass1:"+login.getPassword());
		JSONObject obj=new JSONObject(); 
		// System.out.println("pass2:"+user.getPassword());
		ObjectMapper objectMapper = new ObjectMapper();
		 if (passwordEncoder.matches(login.getPassword(),user.getPassword())) {
		     // System.out.println("The encoding matches 'password'");	
			 {
	    	// System.out.println("pass:"+encodePass.encode(login.getPassword()));
	    	JSONObject dataobj=new JSONObject(user); 
	    	obj.put("data",dataobj); 
			obj.put("login",true);
	    	return obj.toString();
	    }
	}
	    else {
	    	JSONObject dataobj=new JSONObject(); 
	    	obj.put("data",dataobj);   
			obj.put("login",false);
	    	return obj.toString();
	    }
	}
	
	public String isAdminPresent(AdminModel login) {	
		// System.out.println("mail:"+login.getEmailID());
		AdminModel admin = adminrepository.findByemail(login.getEmailID());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// System.out.println("pass1:"+login.getPassword());
		JSONObject obj=new JSONObject();  
		// System.out.println("pass2:"+admin.getPassword());
		ObjectMapper objectMapper = new ObjectMapper();

	    if (passwordEncoder.matches(login.getPassword(),admin.getPassword())) {
		    // System.out.println("The encoding matches 'password'");	
			 {
	    	//System.out.println("pass:"+encodePass.encode(login.getPassword()));
	    	JSONObject dataobj=new JSONObject(admin); 
	    	obj.put("data",dataobj); 
			obj.put("login",true);
	    	return obj.toString();
	    }
	}
	else {
    	JSONObject dataobj=new JSONObject(); 
    	obj.put("data",dataobj);   
		obj.put("login",false);
    	return obj.toString();
    }
	}
	
}
