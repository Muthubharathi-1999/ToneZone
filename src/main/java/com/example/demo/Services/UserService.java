package com.example.demo.Services;

//import java.util.Map;
//import org.json.*;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepository;
	@Autowired
	EncodePass encodePass;
	
	@SuppressWarnings("unchecked")
	public String userSignup(User signup) 
	{
		//User storedUserDetails = userrepository.findByEmail(user.getEmail());
		if(userrepository.findByEmail(signup.getEmail()) != null) throw new RuntimeException("User Already Exists");
		
		
		signup.setPassword(encodePass.encode(signup.getPassword()));
		
		User user=userrepository.save(signup);
		
		JSONObject obj=new JSONObject();
		if(user==null) {
	    	JSONObject dataobj=new JSONObject();
	    	obj.put("data", dataobj);
	    	
	    }
	    else {
	    	org.json.JSONObject dataobj = new org.json.JSONObject(user);
	    	obj.put("data", dataobj);
			return obj.toString();
	    }
		return null;
		
	}
	
}