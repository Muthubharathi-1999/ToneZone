package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class ToneZoneApplication {

	public static void main(String[] args) {
                System.setProperty("server.port", "8081");
		SpringApplication.run(ToneZoneApplication.class, args);
	}

}
