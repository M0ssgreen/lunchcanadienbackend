package fr.solutec.entities;

import java.util.Date;

public class Demande {
	private int idDemande;
	private Event idEvent;
	private Date dateDebut;
	private Date dateFin;
	private User idUser;
	
	
	
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdDemande() {
		return idDemande;
	}
	public void setIdDemande(int idDemande) {
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
