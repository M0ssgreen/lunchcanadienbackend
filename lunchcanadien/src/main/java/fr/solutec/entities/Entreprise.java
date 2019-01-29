package fr.solutec.entities;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "ENTREPRISE")
public class Entreprise extends Base{
	
	private String nom;
	@Column (name="RESPOBONHEUR")
	private User respoBonheur;
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
	public Entreprise(String nom, User respoBonheur, Adresse adresse) {
		super();
		this.nom = nom;
		this.respoBonheur = respoBonheur;
		this.adresse = adresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public User getRespoBonheur() {
		return respoBonheur;
	}
	public void setRespoBonheur(User respoBonheur) {
		this.respoBonheur = respoBonheur;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
