package com.example.demo.Service;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.AdminModel;
import com.example.demo.Model.LoginModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Service
public class AuthService {
	
	@Autowired
	UserRepository userrepository;
	@Autowired
	AdminRepository adminrepository;
	
	public String isUserPresent(LoginModel login) {
		
		UserModel user = userrepository.findByemailAndPassword(login.getEmailID(),login.getPassword());
		JSONObject obj=new JSONObject();   
		JSONObject dataobj=new JSONObject(); 
	    if(user==null) {
	    	obj.put("data",dataobj);   
			obj.put("login",false);
	    	return obj.toString();
	    }
	    else {
	    	dataobj.put("email", user.getEmailID());
			dataobj.put("password", user.getPassword());
	    	obj.put("data",dataobj);   
			obj.put("login",true);
			return obj.toString();
	    }
	}
	
	public String isAdminPresent(AdminModel login) {
		
		AdminModel admin = adminrepository.findByemailAndPassword(login.getEmailID(),login.getPassword());
	    //boolean passb = adminrepository.existsByPassword(login.getPassword());
		//ObjectMapper mapper = new ObjectMapper();
		JSONObject obj=new JSONObject();   
		JSONObject dataobj=new JSONObject(); 
		
	    if(admin==null){
	    	obj.put("data",dataobj);   
			obj.put("login",false);
	    	return obj.toString();
	    }
	    else {
	    	dataobj.put("email", admin.getEmailID());
			dataobj.put("password", admin.getPassword());
	    	obj.put("data",dataobj);   
			obj.put("login",true);
	    	return obj.toString();
	    }
	}
	
}
