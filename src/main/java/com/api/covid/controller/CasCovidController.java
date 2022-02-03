package com.api.covid.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.covid.entity.CasCovid;
import com.api.covid.service.CasCovidService;



@RestController
public class CasCovidController {
	
	@Autowired
	private CasCovidService casCovidService;
	
	  //@Scheduled(cron = "@hourly")
	@Scheduled(fixedDelayString = "PT1440M")
	 //@EventListener(ApplicationReadyEvent.class)
	  public void findAllCas() throws IOException {
		//Files.deleteIfExists(Paths.get("src/main/resources/file.csv"));
		casCovidService.deleteAll();
	    casCovidService.saveData();
	  }
	
	@GetMapping("/covid/dataByCountry")
	  public List<CasCovid> findCasByCountry(@RequestParam String country) {
	    return casCovidService.getByCountry(country);
	  }
	
	@GetMapping("/covid/todayDataByCountry")
	  public String findCasByCountryNow(@RequestParam String country) {
		return casCovidService.getByCountryNow(country).toString();
	  }
	
	@GetMapping("/covid/dataByCountryByDate")
	  public String findCasByCountryByDate(@RequestParam String country, @RequestParam String date) {
		return casCovidService.getByCountryDate(country, date).toString();
	  }
	
}
