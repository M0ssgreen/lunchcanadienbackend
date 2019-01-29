package fr.solutec.entities;


import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EVENEMENT")
public class Event extends Base {
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private Instant quantieme;
	private String nom;
	private int statut;
	
	
	
	public Event() {
		super();
	}
	
	
	
	public Event(Instant quantieme, String nom, int statut) {
		super();
		this.quantieme = quantieme;
		this.nom = nom;
		this.statut = statut;
	}



	public Instant getQuantieme() {
		return quantieme;
	}
	public void setQuantieme(Instant quantiemE) {
		this.quantieme = quantiemE;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
	

}
