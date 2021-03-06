package com.api.covid.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.covid.entity.*;

@Repository
public interface CasCovidRepository extends JpaRepository<CasCovid,Integer>{

	List<CasCovid> findByPays(String country);
//selection des enregistrements pas pays et par date	
	@Query("select c from CasCovid c where c.pays = :country and c.date = :date")
	List<CasCovid> findByCountryDate(String country, String date);
	
	  
	  @Query("select c from CasCovid c where c.pays = :country and c.date = :date")
	  Double findByCountryDateI(String country, String date);
	  
	  
}

