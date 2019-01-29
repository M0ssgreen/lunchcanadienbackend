package fr.solutec.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class User extends Base {
	
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private String telephone;
}