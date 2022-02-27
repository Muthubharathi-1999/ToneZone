package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.Model.AdminModel;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.AdminModel;


@Repository
public interface AdminRepository extends JpaRepository<AdminModel, String> {

	AdminModel findByEmailAndPassword(String email,String password);
	AdminModel findByemail(String email);
	boolean existsByEmail(String email);
	boolean existsByPassword(String password);

}

