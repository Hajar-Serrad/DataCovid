package com.api.covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DataCovidApplication {
//invocation des controlleurs de l'application
	public static void main(String[] args) {
		SpringApplication.run(DataCovidApplication.class, args);		
	}
	

}
