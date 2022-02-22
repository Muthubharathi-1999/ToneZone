package com.example.demo.Services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

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
