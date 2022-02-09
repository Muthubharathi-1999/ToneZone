package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.Model.AdminModel;

public interface AdminRepository extends JpaRepository<AdminModel, String> {
	boolean existsByEmail(String email);
	boolean existsByPassword(String password);

}
