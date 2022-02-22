package com.example.demo.Services;

import com.example.demo.Model.LoginModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Model.LoginModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import java.util.List;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	EncodePass encodePass;
	

	public String userSignup(UserModel signup)
	{

		if(userRepository.findByemail(signup.getEmail()) != null) throw new RuntimeException("User Already Exists");
		
		
		signup.setPassword(encodePass.encode(signup.getPassword()));
		
		UserModel user=userRepository.save(signup);
		
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

	
	public void deleteUser(long UserID) {
		userRepository.deleteById(UserID);
	}

	public UserModel editUser(UserModel user) {
		UserModel um = userRepository.getById(user.getId());
		um.setEmail(user.getEmail());
		um.setPassword(user.getPassword());
		return userRepository.save(um);
	}

	public List<UserModel> getUsers() {
		return (List<UserModel>) userRepository.findAll();
	}

	public UserModel displayUser(long userId) {
		return userRepository.findById(userId).get();
	}



	public String isUserPresent(LoginModel login) {
		// System.out.println("mail:"+login.getEmailID());
		UserModel user = userRepository.findByemail(login.getEmailID());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// System.out.println("pass1:"+login.getPassword());
		org.json.JSONObject obj=new org.json.JSONObject();
		// System.out.println("pass2:"+user.getPassword());
		ObjectMapper objectMapper = new ObjectMapper();
		if (passwordEncoder.matches(login.getPassword(),user.getPassword())) {
			// System.out.println("The encoding matches 'password'");
			{
				// System.out.println("pass:"+encodePass.encode(login.getPassword()));
				org.json.JSONObject dataobj=new org.json.JSONObject(user);
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