package com.api.covid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.api.covid.entity.CasCovid;
import com.api.covid.repository.CasCovidRepository;

@SpringBootApplication
@EnableScheduling
public class DataCovidApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCovidApplication.class, args);
		
		
	}
	

}
