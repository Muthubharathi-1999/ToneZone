package com.example.demo.Services;
import com.example.demo.Model.AdminModel;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.Model.LoginModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.*;
@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminrepository;
	@Autowired
	EncodePass encodePass;
	
	@SuppressWarnings("unchecked")
	public String adminSignup(AdminModel signup)
	{
		
		if(adminrepository.findByemail(signup.getEmail()) != null) throw new RuntimeException("Admin Already Exists");
		
		signup.setPassword(encodePass.encode(signup.getPassword()));
		
		AdminModel admin=adminrepository.save(signup);

		
		JSONObject obj=new JSONObject();

		if(admin==null) {
	    	JSONObject dataobj=new JSONObject();
	    	obj.put("data", dataobj);
	    	
	    }
	    else {
	    	org.json.JSONObject dataobj = new org.json.JSONObject(admin);
	    	obj.put("data", dataobj);
			return obj.toString();
	    }
		return null;

	}


	public String isAdminPresent(AdminModel login) {
		// System.out.println("mail:"+login.getEmailID());
		AdminModel admin = adminrepository.findByemail(login.getEmail());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// System.out.println("pass1:"+login.getPassword());
		org.json.JSONObject obj=new org.json.JSONObject();
		// System.out.println("pass2:"+admin.getPassword());
		ObjectMapper objectMapper = new ObjectMapper();

		if (passwordEncoder.matches(login.getPassword(),admin.getPassword())) {
			// System.out.println("The encoding matches 'password'");
			{
				//System.out.println("pass:"+encodePass.encode(login.getPassword()));
				org.json.JSONObject dataobj=new org.json.JSONObject(admin);
				obj.put("data",dataobj);
				obj.put("login",true);
				return obj.toString();
			}
		}
		else {
			org.json.JSONObject dataobj=new org.json.JSONObject();
			obj.put("data",dataobj);
			obj.put("login",false);
			return obj.toString();
		}
	}

}