package fr.solutec.entities;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name= "ENTREPRISE")
public class Entreprise extends Base{
	
	private String nom;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "ID_UTILISATEUR")
	private User user;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "ID_ADRESSE")
    private Adresse adresse;
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Entreprise(Long id, Instant creation, Instant maj) {
		super(id, creation, maj);
		// TODO Auto-generated constructor stub
	}
	public Entreprise(String nom, User user, Adresse adresse) {
		super();
		this.nom = nom;
		this.user = user;
		this.adresse = adresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
