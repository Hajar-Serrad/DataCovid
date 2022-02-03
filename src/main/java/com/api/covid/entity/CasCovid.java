package com.api.covid.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CasCovid")
public class CasCovid {
	
	@GeneratedValue
	@Id
	@JsonIgnore
	private int id;
	private String date;
	private String pays;
	private int  infections;
	private int  deces;
	private int  guerisons;
	private double  tauxDeces;
	private double  tauxGuerisons;
	private double  tauxInfections;
	
	
	
	public CasCovid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CasCovid(String date, String pays, int infections, int deces, int guerisons,
			double tauxDeces, double tauxguerisons, double tauxinfections) {
		super();
		this.date = date;
		this.pays = pays;
		this.infections = infections;
		this.deces = deces;
		this.guerisons = guerisons;
		this.tauxDeces = tauxDeces;
		this.tauxGuerisons = tauxguerisons;
		this.tauxInfections = tauxinfections;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public int getInfections() {
		return infections;
	}
	public void setInfections(int infections) {
		this.infections = infections;
	}
	public int getDeces() {
		return deces;
	}
	public void setDeces(int deces) {
		this.deces = deces;
	}
	public int getGuerisons() {
		return guerisons;
	}
	public void setGuerisons(int guerisons) {
		this.guerisons = guerisons;
	}
	public double getTauxDeces() {
		return tauxDeces;
	}
	public void setTauxDeces(double tauxDeces) {
		this.tauxDeces = tauxDeces;
	}
	public double getTauxGuerisons() {
		return tauxGuerisons;
	}
	public void setTauxGuerisons(double tauxguerisons) {
		this.tauxGuerisons = tauxguerisons;
	}
	public double getTauxInfections() {
		return tauxInfections;
	}
	public void setTauxInfections(double tauxinfections) {
		this.tauxInfections = tauxinfections;
	}
	@Override
	public String toString() {
		String nL = System.getProperty("line.separator");
		return "Evolution du Coronavirus (Covid19) - " + pays + " - "+ date +": "+ nL + nL +"\t\t" + infections + " cas d'infections "+ nL + nL +"\t\t" + deces
				+ " cas de décès "+ nL + nL +"\t\t" + guerisons + " cas guéris";
	}
	
	
	
	
	

}
