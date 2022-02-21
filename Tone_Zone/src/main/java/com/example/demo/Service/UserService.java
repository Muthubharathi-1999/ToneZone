package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.UserModel;

public interface UserService {
	
	public UserModel displayUser(int UserID);
	
	public List<UserModel> getUsers();

	public UserModel editUser(UserModel usermodel);
	
	public void deleteUser(int UserID);
	
}