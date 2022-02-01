package com.api.covid.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.covid.entity.CasCovid;
import com.api.covid.repository.CasCovidRepository;

@Service
public class CasCovidService {
	
	@Autowired
	private CasCovidRepository casCovidRepository;
	
	public void saveData() {
		
		String line="";
		String[] data = null;
		try {
			BufferedReader bf=new BufferedReader(new FileReader("src/main/resources/covidDataFile.csv"));
			bf.readLine();
			bf.readLine();
			bf.readLine();bf.readLine();bf.readLine();bf.readLine();bf.readLine();bf.readLine();
			while((line=bf.readLine())!=null)
			{
				data = line.split(";");
				CasCovid casCovid = new CasCovid();
				
				//String pattern = "yyyy-MM-dd";
				//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

				//String datex = simpleDateFormat.format(data[0]);
				casCovid.setDate(data[0]);
				casCovid.setPays(data[1]);
				casCovid.setInfections(Double.parseDouble(data[2]));
				casCovid.setDeces(Double.parseDouble(data[3]));
				casCovid.setGuerisons(Double.parseDouble(data[4]));
				casCovid.setTauxDeces(Double.parseDouble(data[5]));
				casCovid.setTauxGuerisons(Double.parseDouble(data[6]));
				casCovid.setTauxInfections(Double.parseDouble(data[7]));
				
				casCovidRepository.save(casCovid);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
