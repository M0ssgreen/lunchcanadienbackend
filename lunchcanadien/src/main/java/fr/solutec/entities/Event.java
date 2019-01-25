package fr.solutec.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.OneToMany;
@Entity
public class Event {
	@Id @GeneratedValue
	private Long idEvent;
	private int nbUser;
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date dateDebut;
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date dateFin;
	private boolean status;
	@OneToMany
	private List<Demande> demande;
	
	
	
	public Event(int nbUser, Date dateDebut, Date dateFin, boolean status) {
		super();
		this.nbUser = nbUser;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.status = status;
	}

	public Event(Long idEvent, int nbUser, Date dateDebut, Date dateFin, boolean status, List<Demande> demande) {
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

	public Long getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(Long idEvent) {
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
