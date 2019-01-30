package fr.solutec.entities;


import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private String resto;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "ID_ADRESSE")
    private Adresse Adresse;
	
	
	
	public Event() {
		super();
	}

	public Event(Instant quantieme, String nom, int statut, String resto, Adresse adresse) {
		super();
		this.quantieme = quantieme;
		this.nom = nom;
		this.statut = statut;
		this.resto = resto;
		Adresse = adresse;
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
	public String getResto() {
		return resto;
	}
	public void setResto(String resto) {
		this.resto = resto;
	}

	public Adresse getAdresse() {
		return Adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.Adresse = adresse;
	}

}
