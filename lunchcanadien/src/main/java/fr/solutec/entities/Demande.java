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
	@ManyToOne(cascade=CascadeType.MERGE)
	private User user;
	
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Demande(Event event, User user) {
		super();
		this.event = event;
		this.user = user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	


	
	

}
