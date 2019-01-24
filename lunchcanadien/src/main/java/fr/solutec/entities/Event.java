package fr.solutec.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.OneToMany;
@Entity
public class Event {
	@Id @GeneratedValue
	private int idEvent;
	private int nbUser;
	@CreationTimestamp
	private Date dateDebut;
	@CreationTimestamp
	private Date dateFin;
	private boolean status;
	@OneToMany
	private List<Demande> demande;
	
	public Event(int idEvent, int nbUser, Date dateDebut, Date dateFin, boolean status, List<Demande> demande) {
		super();
		this.idEvent = idEvent;
		this.nbUser = nbUser;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.status = status;
		this.demande = demande;
	}

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
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
