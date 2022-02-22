package com.example.demo.Service;
import java.beans.JavaBean;
import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncodePass {
public String encode(String password)
	{
		 int strength = 10;
		 BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
		 //BCryptPasswordEncoder bCryptPasswordEncoder =
		// new BCryptPasswordEncoder(strength, new SecureRandom());
		 String encodedPassword = passwordEncoder.encode(password);
		 System.out.println("encoded pass:"+encodedPassword);
		 return encodedPassword;
	}
	
}
