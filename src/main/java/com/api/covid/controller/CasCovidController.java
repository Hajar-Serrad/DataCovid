package com.api.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.covid.entity.CasCovid;
import com.api.covid.service.CasCovidService;



@RestController
public class CasCovidController {
	
	@Autowired
	private CasCovidService casCovidService;
	
	@RequestMapping(path="/cas")
	  public void findAllCas() {
	    casCovidService.saveData();
	  }
	
	@GetMapping("/cas/{country}")
	  public List<CasCovid> findCasByCountry(@PathVariable String country) {
	    return casCovidService.getByCountry(country);
	  }
	
	@GetMapping("/cas/{country}/{date}")
	  public List<CasCovid> findCasByCountryDate(@PathVariable String country, @PathVariable String date) {
		return casCovidService.getByCountryDate(country, date);
	  }
	/*
	@GetMapping("/cas/{country}")
	  public List<CasCovid> findCasByCountry(@PathVariable String country) {
	    return casCovidService.getByCountry(country);
	  }
*/
}
