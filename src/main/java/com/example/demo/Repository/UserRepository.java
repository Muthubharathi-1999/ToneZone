package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
	//static boolean isUserPresent(String ID, String Password) {
		//UserRepository.
	//};
	
	List<UserModel> findAll();
	
	boolean existsByEmail(String email);
	boolean existsByPassword(String password);
	

}

