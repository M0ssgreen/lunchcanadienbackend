package fr.solutec.entities;

public class JoinAdresseEvent {
	private Event event;
	private Adresse adresse;
	public JoinAdresseEvent(Event event, Adresse adresse) {
		super();
		this.event = event;
		this.adresse = adresse;
	}
	public JoinAdresseEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
