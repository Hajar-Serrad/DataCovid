package com.api.covid.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CasCovid")
public class CasCovid {
	
	@GeneratedValue
	@Id
	private int id;
	private String date;
	private String pays;
	private double  infections;
	private double  deces;
	private double  guerisons;
	private double  tauxDeces;
	private double  tauxGuerisons;
	private double  tauxInfections;
	
	
	
	public CasCovid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CasCovid(String date, String pays, double infections, double deces, double guerisons,
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
	public double getInfections() {
		return infections;
	}
	public void setInfections(double infections) {
		this.infections = infections;
	}
	public double getDeces() {
		return deces;
	}
	public void setDeces(double deces) {
		this.deces = deces;
	}
	public double getGuerisons() {
		return guerisons;
	}
	public void setGuerisons(double guerisons) {
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
		return "Cas_Covid [date=" + date + ", pays=" + pays + ", infections=" + infections + ", deces=" + deces
				+ ", guerisons=" + guerisons + ", tauxDeces=" + tauxDeces + ", tauxguerisons=" + tauxGuerisons
				+ ", tauxinfections=" + tauxInfections + "]";
	}
	
	
	

}
