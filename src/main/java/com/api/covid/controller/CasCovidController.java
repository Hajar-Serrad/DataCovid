package com.api.covid.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.covid.entity.CasCovid;
import com.api.covid.service.CasCovidService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RequestMapping("/covid")
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
	@ApiOperation(value="Retourne les données d'un pays donné en entrée jour par jour")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=400,message="Requette non réussie")
	})
	@GetMapping("/dataByCountry")
	  public List<CasCovid> findCasByCountry(@RequestParam String country) {
	    return casCovidService.getByCountry(country);
	  }

//Retourne les données relatives à un pays donné à une date donnée	
	@ApiOperation(value="Retourne les données d'un pays donné à une date donnée")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=404,message="Ressources pas trouvées"),
			@ApiResponse(code=400,message="Requette non réussie")
	})
	@GetMapping("/todayDataByCountry")
	  public CasCovid findCasByCountryNow(@RequestParam String country) {
		//return casCovidService.getByCountryNow(country).toString();
		return casCovidService.getByCountryNow(country);
	  }

//Retourne les données relatives à un pays donné à la date du jour
	@ApiOperation(value="Retourne les données d'un pays donné à la date du jour")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=404,message="Ressources pas trouvées"),
			@ApiResponse(code=400,message="Requette non réussie")
	})
	@GetMapping("/dataByCountryByDate")
	  public CasCovid findCasByCountryByDate(@RequestParam String country, @RequestParam String date) {
		//return casCovidService.getByCountryDate(country, date).toString();
		return casCovidService.getByCountryDate(country, date);
	  }
	
}
