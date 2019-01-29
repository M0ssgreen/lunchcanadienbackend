package fr.solutec.services;
import java.util.ArrayList;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.AdresseRepository;
import fr.solutec.dao.DemandeRepository;
import fr.solutec.dao.EventRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Adresse;
import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;
@Service
public class EventServices {
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private DemandeRepository demandes;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdresseRepository adresseRepository;
	
	private AdresseServices adresseServices;
	private MailServices mailServices;
	private UserServices userServices;
	
	public List<Event> eventByMail(String mail){
		List<Event> eventFromMail = new ArrayList();
		List<Demande> demandeAll = demandes.findAll();
		User user = userRepository.findByEmail(mail).get(0);
		
		for (Demande demande : demandeAll) {
			if (demande.getUser().getId() == user.getId()) {
				eventFromMail.add(eventRepository.findById(demande.getEvent().getId()).get());
			}
		}
		return eventFromMail;
	}
	
	public List<Event> getIdByDate(Instant dateEvent) {
		/*List<Event> listEvent = eventRepository.findAll();
		Event retour = null;
		for (Event event : listEvent) {
			if (dateEvent.equals(event.getDate())) {
				retour=event;
			}
		}
		return retour;*/
		return eventRepository.findByQuantieme(dateEvent);
	}
	
	public void validationRh(Adresse adresse, Event event) {
		List<Event> events = new ArrayList();
		List<Adresse> adresses = new ArrayList();
		List<User> users = new ArrayList();
		Adresse adresseVerif=adresse;
		
		Boolean boolVerif = false;
		events.add(eventRepository.findById(event.getId()).get());
		events.get(0).setResto(event.getResto());
		for (Adresse a:adresses) {
			if (a.getNumero()==adresse.getNumero() && a.getRue()==adresse.getRue() && a.getCodePostal()==adresse.getCodePostal() && a.getVille()==adresse.getVille()) {
				adresseVerif=a;
				boolVerif = true;		
			}
			
			
		}
		if (boolVerif == false) {
			adresseVerif=adresseServices.createAdresse(adresse);
		}
		events.get(0).setAdresse(adresseVerif);
		eventRepository.save(events.get(0));
		users = userServices.getUserByEvent(events.get(0));
		mailServices.envMailGroupe(users);
		
	}
	
	public Event createEvent(Event event) {
		
		return eventRepository.save(event);
	}	
	
	public Event setRestoEvent(Long idEvent, String resto, Long idAdresse) {
		Event e = eventRepository.findById(idEvent).get();
		e.setResto(resto);
		Adresse a = adresseRepository.findById(idAdresse).get();
		e.setAdresse(a);
		return eventRepository.save(e);
	}

}
