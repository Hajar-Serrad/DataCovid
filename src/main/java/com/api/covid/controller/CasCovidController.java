package com.api.covid.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.covid.entity.CasCovid;
import com.api.covid.service.CasCovidService;



@RestController
public class CasCovidController {
	
	@Autowired
	private CasCovidService casCovidService;
	
//Re-importation des données chaque jour
	//@Scheduled(fixedDelayString = "PT1440M")
	 // public void findAllCas() throws IOException {
		//casCovidService.deleteAll();
	    //casCovidService.saveData();
	  //}
//Retourne les données relatives à un pays donné en entrée jour par jour
	@GetMapping("/covid/dataByCountry")
	  public List<CasCovid> findCasByCountry(@RequestParam String country) {
	    return casCovidService.getByCountry(country);
	  }

//Retourne les données relatives à un pays donné à une date donnée	
	@GetMapping("/covid/todayDataByCountry")
	  public CasCovid findCasByCountryNow(@RequestParam String country) {
		//return casCovidService.getByCountryNow(country).toString();
		return casCovidService.getByCountryNow(country);
	  }

//Retourne les données relatives à un pays donné à la date du jour
	@GetMapping("/covid/dataByCountryByDate")
	  public CasCovid findCasByCountryByDate(@RequestParam String country, @RequestParam String date) {
		//return casCovidService.getByCountryDate(country, date).toString();
		return casCovidService.getByCountryDate(country, date);
	  }
	
}
