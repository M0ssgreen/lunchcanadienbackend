package fr.solutec.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="adresse")
public class Adresse extends Base {

	private String rue;
	private String numero;
	@Column(name = "CODE_POSTAL")
	private String codePostal;
	private String ville;
	private String resto;
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Adresse(Long id, Instant creation, Instant maj) {
		super(id, creation, maj);
		// TODO Auto-generated constructor stub
	}
	public Adresse(String rue, String numero, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Adresse(String rue, String numero, String codePostal, String ville, String resto) {
		super();
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;
		this.ville = ville;
		this.resto = resto;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getResto() {
		return resto;
	}
	public void setResto(String resto) {
		this.resto = resto;
	}
	
	
}
