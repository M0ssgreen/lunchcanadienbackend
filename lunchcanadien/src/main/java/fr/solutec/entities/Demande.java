package fr.solutec.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="demande")
public class Demande {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDemande;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="idEvent")
	private Event event;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "idUser")
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
