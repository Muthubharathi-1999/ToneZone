package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.AdminModel;

public interface AdminRepository extends JpaRepository<AdminModel, String> {
	
	
	//boolean existsByEmailAndexistsByPassword(String email,String password);
	//@Query(value="select * from admins where email=:email")
	AdminModel findByemailAndPassword(String email,String password);
	AdminModel findByemail(String email);
	
	boolean existsByEmail(String email);
	boolean existsByPassword(String password);

}
