package com.example.demo.Services;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncodePass {
	public String encode(String password)
	{
		 int strength = 10;
		 BCryptPasswordEncoder bCryptPasswordEncoder =
		 new BCryptPasswordEncoder(strength, new SecureRandom());
		 String encodedPassword = bCryptPasswordEncoder.encode(password);
		 return encodedPassword;
	}
}
