package com.example.demo.Services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Admin;
import com.example.demo.Repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminrepository;
	@Autowired
	EncodePass encodePass;
	
	@SuppressWarnings("unchecked")
	public String adminSignup(Admin signup) 
	{
		
		if(adminrepository.findByEmail(signup.getEmail()) != null) throw new RuntimeException("Admin Already Exists");
		
		signup.setPassword(encodePass.encode(signup.getPassword()));
		
		Admin admin=adminrepository.save(signup);
		
		/*JSONObject obj=new JSONObject();
		JSONObject adminobj = new JSONObject();
		JSONObject aobj = new JSONObject();
	    if(admin==null) {
	    	
	    	obj.put("data",adminobj); 
	    	
	    }
	    else {
	    	
	    	adminobj.put("user",aobj);
	    	aobj.put("id", a.getId());
	    	aobj.put("name", a.getName());
	    	aobj.put("email", a.getEmail());
			aobj.put("password",a.getPassword());
	    	obj.put("data",adminobj);  
			return obj.toString();
	    }
	return null;*/
		
		JSONObject obj=new JSONObject();
    	//JSONObject aobj = new JSONObject();
		if(admin==null) {
	    	JSONObject dataobj=new JSONObject();
	    	obj.put("data", dataobj);
	    	
	    }
	    else {
	    	//obj.put("admin",aobj);
	    	org.json.JSONObject dataobj = new org.json.JSONObject(admin);
	    	obj.put("data", dataobj);
			return obj.toString();
	    }
		return null;
		
		
	}
	
}