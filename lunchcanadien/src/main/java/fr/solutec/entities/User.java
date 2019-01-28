package fr.solutec.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
	@Id @GeneratedValue
	private Long idUser;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private String entreprise;
	@OneToMany
	private List<Demande> demande;
		
	public User(String nom, String prenom, String mail, String mdp, String entreprise) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.entreprise = entreprise;
	}
	public User(Long idUser, String nom, String prenom, String mail, String mdp, String entreprise,
			List<Demande> demande) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.entreprise = entreprise;
		this.demande = demande;
	}
	
	public User( String nom, String mail) {
		super();
		this.nom = nom;
		this.mail = mail;
	}
	
	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public Long getId() {
		return idUser;
	}


	public void setId(Long idUser) {
		this.idUser = idUser;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	
}