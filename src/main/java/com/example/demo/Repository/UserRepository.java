package com.example.demo.Repository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.AdminModel;
import com.example.demo.Model.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
	UserModel findByemail(String email);
	boolean existsByEmail(String email);
	boolean existsByPassword(String password);

	UserModel findByemailAndPassword(String email, String password);
	
}


