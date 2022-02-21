package com.example.demo.Services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import java.util.List;

@Service
public class UserService {
	
	@Autowired
	UserRepository userReository;
	@Autowired
	EncodePass encodePass;
	
	@SuppressWarnings("unchecked")
	public String userSignup(User signup) 
	{
		//User storedUserDetails = userReository.findByEmail(user.getEmail());
		if(userReository.findByEmail(signup.getEmail()) != null) throw new RuntimeException("User Already Exists");
		
		
		signup.setPassword(encodePass.encode(signup.getPassword()));
		
		User user=userReository.save(signup);
		
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
		userReository.deleteById(UserID);
	}

	public User editUser(User user) {
		User um = userReository.getById(user.getId());
		um.setEmail(user.getEmail());
		um.setPassword(user.getPassword());
		return userReository.save(um);
	}

	public List<User> getUsers() {
		return (List<User>) userReository.findAll();
	}

	public User displayUser(long userId) {
		return userReository.findById(userId).get();
	}
	
}