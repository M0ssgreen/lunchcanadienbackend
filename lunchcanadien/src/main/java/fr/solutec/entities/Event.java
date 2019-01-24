package fr.solutec.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Event {
	@Id @GeneratedValue
	private int idEvent;
	private int nbUser;
	private Date dateDebut;
	private Date dateFin;
	private int status;
	
	@OneToMany
	private List<Demande> demande;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public int getNbUser() {
		return nbUser;
	}
	public void setNbUser(int nbUser) {
		this.nbUser = nbUser;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
