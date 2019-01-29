package fr.solutec.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "UTILISATEUR")
public class User extends Base {
	
	private String nom;
	private String prenom;
	@Column(unique=true)
	private String email;
	private String mdp;
	private String telephone;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "ID_ENTREPRISE")
	private Entreprise entreprise;
	
	
	
	public Entreprise getEntreprise() {
		return entreprise;
	}



	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}



	public User(String nom, String prenom, String email, String mdp, String telephone, Entreprise entreprise) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.telephone = telephone;
		this.entreprise = entreprise;
	}



	public User() {
		super();
	}
	
	
	
	public User(String nom, String prenom, String email, String mdp, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.telephone = telephone;
	}



	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}