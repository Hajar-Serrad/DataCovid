package com.api.covid;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.api.covid.service.CasCovidService;

@SpringBootApplication
@EnableScheduling
public class DataCovidApplication {
	@Autowired
	private CasCovidService casCovidService;
	
//invocation des controlleurs de l'application
	public static void main(String[] args) {
		SpringApplication.run(DataCovidApplication.class, args);		
	}
	
	
//Re-importation des données chaque jour
	@Scheduled(fixedDelayString = "PT1440M")
	  public void findAllCas() throws IOException {
		casCovidService.deleteAll();
	    casCovidService.saveData();
	  }
	

}
