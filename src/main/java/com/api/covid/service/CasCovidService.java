package com.api.covid.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.covid.entity.CasCovid;
import com.api.covid.repository.CasCovidRepository;

@Service
public class CasCovidService {
	
	@Autowired
	private CasCovidRepository casCovidRepository;
	
	public void saveData() {
		
		casCovidRepository.deleteAll();
		String line="";
		String[] data = null;
		try {
			
			URL fetchWebsite = new URL("https://coronavirus.politologue.com/data/coronavirus/coronacsv.aspx?format=csv&t=pays");

	        Path path = Paths.get("src/main/resources/file2.csv");
	        try (InputStream inputStream = fetchWebsite.openStream()) {
	            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
	        }
	        
			BufferedReader bf=new BufferedReader(new FileReader("src/main/resources/file2.csv"));
			for(int i=0; i<8; i++)
				bf.readLine();
			
			while((line=bf.readLine())!=null)
			{
				data = line.split(";");
				CasCovid casCovid = new CasCovid();
				
				casCovid.setDate(data[0]);
				casCovid.setPays(data[1]);
				casCovid.setInfections(Integer.parseInt(data[2]));
				casCovid.setDeces(Integer.parseInt(data[3]));
				casCovid.setGuerisons(Integer.parseInt(data[4]));
				casCovid.setTauxDeces(Double.parseDouble(data[5]));
				casCovid.setTauxGuerisons(Double.parseDouble(data[6]));
				casCovid.setTauxInfections(Double.parseDouble(data[7]));
				
				casCovidRepository.save(casCovid);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<CasCovid> getByCountry(String country)
	{
		//
		return casCovidRepository.findByPays(country);
	}
	
	public CasCovid getByCountryDate(String country, String date)
	{
		//
		List<CasCovid> res = new ArrayList<>();
		CasCovid c = new CasCovid();
		List<CasCovid> casCovid = casCovidRepository.findByPays(country);
		for(int i=0; i<casCovid.size(); i++) {
			if(casCovid.get(i).getDate().equals(date))
			{
				res.add(casCovid.get(i));
				res.add(casCovid.get(i+1));
				
				c.setDate(date);
				c.setDeces(res.get(0).getDeces()-res.get(1).getDeces());
				c.setInfections(res.get(0).getInfections()-res.get(1).getInfections());
				c.setPays(country);
				c.setGuerisons(res.get(0).getGuerisons()-res.get(1).getGuerisons());
				
				
			}
		}
		
		return c;
		
		
			
				
	}
	
	public CasCovid getByCountryNow(String country)
	{
		//
		List<CasCovid> res = new ArrayList<>();
		CasCovid c = new CasCovid();
		List<CasCovid> casCovid = casCovidRepository.findByPays(country);
		java.util.Date date =  Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = dateFormat.format(date);  
		for(int i=0; i<casCovid.size(); i++) {
			if(casCovid.get(i).getDate().equals(strDate))
			{
				res.add(casCovid.get(i));
				res.add(casCovid.get(i+1));
				
				c.setDate(strDate);
				c.setDeces(res.get(0).getDeces()-res.get(1).getDeces());
				c.setInfections(res.get(0).getInfections()-res.get(1).getInfections());
				c.setPays(country);
				c.setGuerisons(res.get(0).getGuerisons()-res.get(1).getGuerisons());
				
				
			}
		}
		
		return c;
		
		
			
				
	}
	
	public Double getByCountryDateI(String country, String date)
	{
		//
		return casCovidRepository.findByCountryDateI(country, date);
	}
	
	public List<CasCovid> getCasCovid() {
		return casCovidRepository.findAll();
	}
	
	public void deleteAll() {
		casCovidRepository.deleteAll();
	}
	

}
