package com.api.covid.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.covid.entity.*;

@Repository
public interface CasCovidRepository extends JpaRepository<CasCovid,Integer>{

}

