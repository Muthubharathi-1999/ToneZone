package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository rep;
	
	@Override
	public void deleteUser(int UserID) {
		rep.deleteById(UserID);
		
	}

	@Override
	public UserModel editUser(UserModel usermodel) {
		Integer id = usermodel.getUserID();
		UserModel um = rep.getById(id);
		System.out.println(usermodel.getUserID());
		um.setEmail(usermodel.getEmail());
		um.setPassword(usermodel.getPassword());
		um.setMobileNumber(usermodel.getMobileNumber());
		um.setUsername(usermodel.getUsername());
		um.setUserRole(usermodel.getUserRole());
		return rep.save(um);
	}

	@Override
	public List<UserModel> getUsers() {
		return (List<UserModel>) rep.findAll();
	}

	@Override
	public UserModel displayUser(int UserID) {
		return rep.findById(UserID).get();
	}


	
}
