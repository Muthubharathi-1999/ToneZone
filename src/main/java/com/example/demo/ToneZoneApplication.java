package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class ToneZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToneZoneApplication.class, args);
	}

}
