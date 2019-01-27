package fr.solutec.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Demande {
	@Id @GeneratedValue
	private Long idDemande;
	@ManyToOne(cascade=CascadeType.MERGE)
	private Event event;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private Date dateDebut;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private Date dateFin;
	private boolean status;
	@ManyToOne(cascade=CascadeType.MERGE)
	private User user;
	
	
	
	public Demande(Date dateDebut, Date dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Demande(Long idDemande, Event idEvent, Date dateDebut, Date dateFin, boolean status, User user) {
		super();
		this.idDemande = idDemande;
		this.event = idEvent;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.user = user;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdDemande() {
		return idDemande;
	}
	public void setIdDemande(Long idDemande) {
		this.idDemande = idDemande;
	}
	public Event getIdEvent() {
		return event;
	}
	public void setIdEvent(Event event) {
		this.event = event;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
