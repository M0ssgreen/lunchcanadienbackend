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
	@Column (name="EMAIL_RH")
	private String emailRh;
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
	public Entreprise(String nom, String emailRh, Adresse adresse) {
		super();
		this.nom = nom;
		this.emailRh = emailRh;
		this.adresse = adresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmailRh() {
		return emailRh;
	}
	public void setEmailRh(String emailRh) {
		this.emailRh = emailRh;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
