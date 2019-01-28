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
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date date;
	@OneToMany
	private List<Demande> demande;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Event(Long idEvent, Date date, List<Demande> demande) {
		super();
		this.idEvent = idEvent;
		this.date = date;
		this.demande = demande;
	}
	public Long getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Demande> getDemande() {
		return demande;
	}
	public void setDemande(List<Demande> demande) {
		this.demande = demande;
	}
	
	
	
	
	

}
