package com.example.demo.Service;

import com.example.demo.Model.UserModel;

public interface UserService {

	public UserModel editUser(UserModel usermodel);
	
	public void deleteUser(int UserID);
	
}
