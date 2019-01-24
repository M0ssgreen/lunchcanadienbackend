package fr.solutec.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Demande {
	@Id @GeneratedValue
	private Long idDemande;
	@ManyToOne(cascade=CascadeType.MERGE)
	private Event idEvent;
	private Date dateDebut;
	private Date dateFin;
	@ManyToOne(cascade=CascadeType.MERGE)
	private User idUser;
	
	
	
	public Demande(Date dateDebut, Date dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Demande(Long idDemande, Event idEvent, Date dateDebut, Date dateFin, User idUser) {
		super();
		this.idDemande = idDemande;
		this.idEvent = idEvent;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idUser = idUser;
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
		return idEvent;
	}
	public void setIdEvent(Event idEvent) {
		this.idEvent = idEvent;
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
	public User getIdUser() {
		return idUser;
	}
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
	
	

}
